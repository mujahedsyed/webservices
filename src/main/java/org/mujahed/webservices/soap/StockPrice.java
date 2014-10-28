package org.mujahed.webservices.soap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, use = SOAPBinding.Use.LITERAL)
public interface StockPrice {
    public String getStockPrice(String stock);
}