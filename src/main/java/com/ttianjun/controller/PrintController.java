package com.ttianjun.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletOutputStream;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import com.jfinal.core.Controller;

public class PrintController extends Controller {
	JasperReport jasperReport;
	JasperPrint jasperPrint;

	public void index() throws JRException, IOException {
		renderNull();
		String root = "E:\\tianjun2\\print\\";
		jasperReport = JasperCompileManager.compileReport(root + "hell.jrxml");
		jasperPrint = JasperFillManager.fillReport(jasperReport, null,
				new JREmptyDataSource());
		ServletOutputStream ouputStream = getResponse().getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
		oos.writeObject(jasperPrint);
		oos.flush();
		oos.close();

	}
}
