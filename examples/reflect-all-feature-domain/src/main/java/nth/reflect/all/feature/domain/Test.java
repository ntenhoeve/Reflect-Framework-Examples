package nth.reflect.all.feature.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import nth.reflect.fw.layer3domain.DomainObject;
import nth.reflect.fw.layer3domain.DomainObjectProperty;
import nth.reflect.fw.layer5provider.reflection.behavior.fieldmode.TextFieldMode;
import nth.reflect.fw.layer5provider.reflection.behavior.fieldmode.TextFieldModeType;
import nth.reflect.fw.layer5provider.reflection.behavior.format.Format;
import nth.reflect.fw.layer5provider.reflection.behavior.order.Order;

/**
 * {@link DomainObject} class to test all the supported
 * {@link DomainObjectProperty} types.
 * 
 * @author nilsth
 *
 */
public class Test {
	private boolean myBoolean;
	// private Test myTest;//TODO this will cause an infinate
	// loop in the ReflectionProvider
	private byte myByte;
	private short myShort;
	private int myInt;
	private long myLong;
	private float myFloat;
	private double myDouble;
	private AtomicInteger myAtomicInteger;
	private AtomicLong myAttomicLong;
	private BigDecimal myBigDecimal;
	private BigInteger myBigInteger;
	private char myChar;
	private String myText;
	private String myTextArea;
	private String myPassWord;
	private Date myDate;
	private Date myTime;
	private Date myDateTime;
	private Calendar myCalendar;
	private LocalDate myLocalDate;
	private LocalTime myLocalTime;
	private LocalDateTime myLocalDateTime;

	enum PickOrder {
		first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelfth
	}

	private PickOrder myEnum;

	@Order(value = 1)
	public boolean isMyBoolean() {
		return myBoolean;
	}

	public void setMyBoolean(boolean myBoolean) {
		this.myBoolean = myBoolean;
	}

	@Format(pattern = "00")
	public byte getMyByte() {
		return myByte;
	}

	public void setMyByte(byte myByte) {
		this.myByte = myByte;
	}

	public short getMyShort() {
		return myShort;
	}

	public void setMyShort(short myShort) {
		this.myShort = myShort;
	}

	public int getMyInt() {
		return myInt;
	}

	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}

	public long getMyLong() {
		return myLong;
	}

	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}

	public float getMyFloat() {
		return myFloat;
	}

	public void setMyFloat(float myFloat) {
		this.myFloat = myFloat;
	}

	public double getMyDouble() {
		return myDouble;
	}

	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}

	public char getMyChar() {
		return myChar;
	}

	public void setMyChar(char myChar) {
		this.myChar = myChar;
	}

	public String getMyText() {
		return myText;
	}

	public void setMyText(String myText) {
		this.myText = myText;
	}

	@TextFieldMode(mode = TextFieldModeType.TEXT_AREA)
	public String getMyTextArea() {
		return myTextArea;
	}

	public void setMyTextArea(String myTextArea) {
		this.myTextArea = myTextArea;
	}

	@TextFieldMode(mode = TextFieldModeType.PASSWORD)
	public String getMyPassWord() {
		return myPassWord;
	}

	public void setMyPassWord(String myPassWord) {
		this.myPassWord = myPassWord;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	@Format(pattern = "HH:mm:ss")
	public Date getMyTime() {
		return myTime;
	}

	public void setMyTime(Date myTime) {
		this.myTime = myTime;
	}

	@Format(pattern = "dd-mm-yyyy HH:mm:ss")
	public Date getMyDateTime() {
		return myDateTime;
	}

	public void setMyDateTime(Date myDateTime) {
		this.myDateTime = myDateTime;
	}

	public PickOrder getMyEnum() {
		return myEnum;
	}

	public void setMyEnum(PickOrder myEnum) {
		this.myEnum = myEnum;
	}

	// public Test getMyTest() {
	// return myTest;
	// }
	//
	// public void setMyTest(Test myTest) {
	// this.myTest = myTest;
	// }

	public Calendar getMyCalendar() {
		return myCalendar;
	}

	public void setMyCalendar(Calendar myCalendar) {
		this.myCalendar = myCalendar;
	}

	public AtomicInteger getMyAtomicInteger() {
		return myAtomicInteger;
	}

	public void setMyAtomicInteger(AtomicInteger myAtomicInteger) {
		this.myAtomicInteger = myAtomicInteger;
	}

	public AtomicLong getMyAttomicLong() {
		return myAttomicLong;
	}

	public void setMyAttomicLong(AtomicLong myAttomicLong) {
		this.myAttomicLong = myAttomicLong;
	}

	public BigDecimal getMyBigDecimal() {
		return myBigDecimal;
	}

	public void setMyBigDecimal(BigDecimal myBigDecimal) {
		this.myBigDecimal = myBigDecimal;
	}

	public BigInteger getMyBigInteger() {
		return myBigInteger;
	}

	public void setMyBigInteger(BigInteger myBigInteger) {
		this.myBigInteger = myBigInteger;
	}

	public LocalDate getMyLocalDate() {
		return myLocalDate;
	}

	public void setMyLocalDate(LocalDate myLocalDate) {
		this.myLocalDate = myLocalDate;
	}

	public LocalTime getMyLocalTime() {
		return myLocalTime;
	}

	public void setMyLocalTime(LocalTime myLocalTime) {
		this.myLocalTime = myLocalTime;
	}

	public LocalDateTime getMyLocalDateTime() {
		return myLocalDateTime;
	}

	public void setMyLocalDateTime(LocalDateTime myLocalDateTime) {
		this.myLocalDateTime = myLocalDateTime;
	}

}
