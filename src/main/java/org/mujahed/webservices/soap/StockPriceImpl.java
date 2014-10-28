package org.mujahed.webservices.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "org.mujahed.webservices.soap.StockPrice")
public class StockPriceImpl implements StockPrice {
    public String getStockPrice(String stock) {
        if ("Stock1".equals(stock)) {
            return "123";
        } else {
            return "Stock not found";
        }
    }
}