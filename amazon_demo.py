import os

from selenium import webdriver

chromedriver = './driver/chromedriver'
os.environ['webdriver.chrome.driver'] = chromedriver
driver = webdriver.Chrome(chromedriver)
driver.get('http://www.amazon.com/')

input_elem = driver.find_element_by_id('twotabsearchtextbox')
input_elem.send_keys("selenium webdriver")
search_icon = driver.find_element_by_css_selector('#nav-search > form > div.nav-right > div > input')
search_icon.click()

status = driver.find_element_by_id('s-result-count')
print(status.text)
driver.quit()
