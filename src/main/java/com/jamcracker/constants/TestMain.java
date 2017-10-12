package com.jamcracker.constants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

public class TestMain {
	

    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
        TestNG testng = new TestNG(); 
        testng.setXmlSuites((List <XmlSuite>)(new Parser("E:\\Automation JC\\JsdnAutomation_October32017\\JSDNAutomation\\testng.xml").parse()));       
        testng.run();
    }

}
