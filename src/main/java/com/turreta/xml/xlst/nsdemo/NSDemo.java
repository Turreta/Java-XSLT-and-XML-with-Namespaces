package com.turreta.xml.xlst.nsdemo;

import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class NSDemo {
	public static void main(String[] args) {
		
		ClassLoader classLoader = NSDemo.class.getClassLoader();
		
		Source inputXml = new StreamSource(classLoader.getResource("input.xml").getFile());
		Source xsl = new StreamSource(classLoader.getResource("transformation.xsl").getFile());
		Result outputXml = new StreamResult(
				new File("C:\\Users\\sang018\\Desktop\\test-data\\csdb\\New folder\\output.xml"));

		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
			transformer.transform(inputXml, outputXml);
		} catch (TransformerException e) {
			e.getMessage();
		}
	}
}
