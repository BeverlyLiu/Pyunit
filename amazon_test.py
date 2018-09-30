
import unittest
import os
from selenium import webdriver

class AmazonTest(unittest.TestCase):
    def setUp(self):
        chromedriver = './drivers/chromedriver.exe'
        os.environ['webdriver.chrome.driver'] = chromedriver
        self.driver = webdriver.Chrome(chromedriver)
        self.driver.get('http://www.amazon.com/')

    def tearDown(self):
        self.driver.quit()

    def test_amazon_search(self):
        input_elem = self.driver.find_element_by_id('twotabsearchtextbox')
        input_elem.send_keys("selenium webdriver")
        search_icon = self.driver.find_element_by_css_selector('#nav-search > form > div.nav-right > div > input')
        search_icon.click()

        status = self.driver.find_element_by_id('s-result-count')
        status_text = '1-16 of 139 results for "selenium webdriver"'

        self.assertEqual(status_text, status.text)

if __name__ == '__main__':
    unittest.main()
