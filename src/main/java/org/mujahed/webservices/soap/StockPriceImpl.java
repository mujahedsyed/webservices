package org.mujahed.webservices.soap;

import org.apache.log4j.Logger;

import javax.jws.WebService;

@WebService(endpointInterface = "org.mujahed.webservices.soap.StockPrice")
public class StockPriceImpl implements StockPrice {

    static final Logger LOGGER = Logger.getLogger(StockPriceImpl.class);

    public String getStockPrice(String stock) {
        if ("Stock1".equals(stock)) {
            return "123";
        } else {
            return "Stock not found";
        }
    }

    @Override
    public double divide(double a, double b) {
        LOGGER.info("divide method invoked ...");
        return a/b;
    }

    public String sayHello(){
        return "Hello !";
    }
}