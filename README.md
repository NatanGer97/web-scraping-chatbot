## Web Scraper
This is a web scraper that scrapes the websites for product that fit the user keyword search.
The program will scrape the website for fitting products and then will return product information such as the product name, price etc.
Scraping is done using **Jsoup**, and combined with the use of:
1. **Regex**
2. **Json Parsing**

------------

# Technologies used:
**Spring Boot, Java, Docker**, Maven, Jsoup, Webhook


# Deployed
currently, deployed on _repl.it_
you can check it out here: https://natan-chatbot.natanger97.repl.co/swagger-ui.html

------------

# Run with Docker
`  docker run -p 8080:8080 natanger97/web-scraping-chatbot:001
`
---- 
# Run Locally
1. Clone the repository
2. Start the application
3. Go to http://localhost:8080/swagger-ui.html




###### Note: The scraper works for the following websites:
- https://www.amazon.com/
- https://www.ksp.co.il/ (only in local environment, gets blocked in deployment environment)
  the scrapper not done yet, currently working on the following features:
- Integration with a dialogflow agent in order to make a ChatBot
- Deployment to a cloud environment (currently working on it)

