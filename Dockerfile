FROM openjdk:17
COPY out/production/EcommerceApp/ /tmp
WORKDIR /tmp
CMD java consoleApp.StoreApp