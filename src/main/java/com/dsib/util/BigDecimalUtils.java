package com.dsib.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BigDecimalUtils extends BigDecimal {

	private static final long serialVersionUID = 1L;
	

	public BigDecimalUtils(String val) {
		super(val);
	}

	
	public static BigDecimal valueOf(String s) {
		BigDecimal result = BigDecimal.valueOf(0.00);
		try {
			result = valueOf(Double.valueOf(s));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
