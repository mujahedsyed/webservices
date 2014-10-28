package client.soap;

import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class DispatchSoapMessageClient {
    private static final String Namespace = "http://webservices.mujahed.org/";

    public static void main(String[] args) throws Exception {
        // trace request response: http://stackoverflow.com/questions/1945618/tracing-xml-request-responses-with-jax-ws
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

        URL url;
        try {
            url = new URL("http://localhost:8081/webservices/hello?wsdl");
            QName serviceName = new QName(Namespace, "StockPriceImplService");
            QName portName = new QName(Namespace, "StockPriceImplPort");
            Service service = Service.create(url, serviceName);
            Dispatch<Source> dispatch = service.createDispatch(portName, Source.class, Service.Mode.MESSAGE);
            //Dispatch<Source> dispatch = service.createDispatch(portName, Source.class, Service.Mode.PAYLOAD);
            Source response = dispatch.invoke(createSOAPmessage());
            //Source response = dispatch.invoke(createPayloadMessage());
            System.out.println("response :" + response);

            final StringWriter requestXmlWriter = new StringWriter();
            final Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.transform(response, new StreamResult(requestXmlWriter));
            final String requestXml = requestXmlWriter.toString();
            System.out.println("response\n" + requestXml);
        } catch (MalformedURLException e) {
        }
    }

    private static Source createSOAPmessage() {
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservices.mujahed.org/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <web:getStockPrice>\n" +
                "         <arg0>Stock1</arg0>\n" +
                "      </web:getStockPrice>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        Source src = new StreamSource(new java.io.StringReader(xml));
        return src;
    }

    private static Source createPayloadMessage() {
        String xml = "<web:getStockPrice xmlns:web=\"http://webservices.mujahed.org/\" >" +
                "         <arg0>Stock1</arg0>\n" +
                "      </web:getStockPrice>";
        Source src = new StreamSource(new java.io.StringReader(xml));
        return src;
    }
}