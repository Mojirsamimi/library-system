package org.parsisys.tehranuniversity.library.util;




import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import oracle.jbo.domain.Number;

import util.FDate;

public class ParsiUtil {
    private static ArrayList<String> abjad;
    private static ArrayList<String> englishAlphabet;
    public ParsiUtil() {
        super();
   
    
    }
    public static String getFromAbjad(int i) {
        String prefix="";
        if(i-1>27)
            prefix="الف"+" ";
      return prefix+getAbjad().get((i-1)%28);
    }
  public static String getFromEnAlphabet(int i) {
    String prefix="";
    if(i-1>25)
        prefix="a";
    return prefix+ getEnglishAlphabet().get((i-1)%26);
  }
    public static boolean contains(String text,String regex,String word) {
        if(text==null || word==null ||regex==null)
            return false;
            
      String [] splt=text.split(regex);
      for(int i=0;i<splt.length;i++) {
        if(word.equals(splt[i]))
            return true;
      }
      return false;
    }
    public static String deleteWordFromText(String text,String regex,String word) {
        if(text==null)
            return null;
        if(word==null)
            return text;
      String [] splt=text.split(regex);
      String result="";
      for(int i=0;i<splt.length;i++) {
       if(!word.equals(splt[i]))
           result+=regex+splt[i];
      }
      return result.replaceFirst(regex, "");
    }
    public static String encodePersianText(String s) {
        
        String result="";
        
        for(int i=0;i<s.length();i++)
        {
            result+=s.codePointAt(i)+(i+1==s.length()?"":",");
        }
        return result;
    }
    public static Number timeToNumber() {
      Calendar c=Calendar.getInstance();
      int now=c.get(Calendar.HOUR_OF_DAY)*100+c.get(Calendar.MINUTE);
      return new Number(now);
    }
  public static Number timeWithSecToNumber() {
    Calendar c=Calendar.getInstance();
    int i=240000;
    int now=c.get(Calendar.HOUR_OF_DAY)*10000+c.get(Calendar.MINUTE)*100+c.get(Calendar.SECOND);
    return new Number(now);
  }
    
  public static String numberTimeToString(Number time) {
      
    if(time==null)
    return null;
    String h=String.valueOf(time.intValue()/100);
    String m=String.valueOf(time.intValue() % 100);
    if(m.length()<2)
        m="0"+m;
    return h + ":" + m ;
      
  }
    
//      public static String numTimeToString(Number time) {
//      
//    if(time==null)
//    return null;
//    return time.intValue()/100 + ":" + time.intValue() % 100 ;
//      
//  }
//    
  public static Number stringTimeToNumber( String time) {
    if(time==null)
        return null;
    if(!time.contains(":"))
    {
      return null;
    }      
      time=time.replaceAll(":","");
        Number retVal=new Number(0);
        try {
            retVal = new Number(time);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retVal;
    }     
    public static PDate monthAndDayBetweenTwoDate(Number d1,Number d2) {
      int en_y=d1.divide(10000).intValue();
      int en_m=d1.divide(100).mod(100).intValue();
      int en_d=d1.mod(100).intValue();
      int ex_y=d2.divide(10000).intValue();
      int ex_m=d2.divide(100).mod(100).intValue();
      int ex_d=d2.mod(100).intValue();
      int e_temp;
      
      int res_durity_m;
      int res_durity_d;
      e_temp=ex_y-en_y;
      e_temp=e_temp*12;
      res_durity_m=e_temp;
      
      e_temp=ex_m-en_m;
      if(e_temp<0) {
        e_temp=e_temp+12;
        res_durity_m-=12;
      }
      res_durity_m+=e_temp;
      
      e_temp=ex_d-en_d;
      if(e_temp<0) {
        e_temp+=30;
        res_durity_m-=1;
      }
      res_durity_d=e_temp;
      while(res_durity_d>=30) {
        res_durity_d-=30;
          res_durity_m+=1;
      }
      
      return new PDate(new Number(res_durity_m),new Number(res_durity_d));
    }
    public static int compareDates(String d1,String d2) {
      if(d1==null && d2==null)
        return 0;
      if(d1==null && d2!=null)
          return -1;
      if(d1!=null && d2==null)
          return 1;
      
      d1=d1.replaceAll("/", "");
      d2=d2.replaceAll("/", "");
      Number nd1;
      Number nd2;

        try {
            nd1 = new Number(d1);
            nd2=new Number(d2);
            return nd1.compareTo(nd2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static String clearString(String s) {
      if(s==null || "".equalsIgnoreCase(s.trim()))
          return null;
      return s.trim();
    }
  public static String stringToZeroValue(String s) {
    if("".equalsIgnoreCase(s) || s==null)
        return "0";
    return s;
  }
    public static String numberDateToString(Number date) {
      if(date==null)
      return null;
      return date.intValue()/10000 +"/"+(date.intValue()/100)%100+"/"+date.intValue()%100;
      
    }
 
    public static Number stringDateToNumber(String date) {
      if(date==null)
          return null;
      if(!date.contains("/"))
      {
            try {
                return new Number(date);
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
      String[] sDate=date.split("/");
      int y=Integer.parseInt(sDate[0]);
      int m =Integer.parseInt(sDate[1]);
      int d =Integer.parseInt(sDate[2]);
      
      return new Number(y*10000+m*100+d);
      
    }
    public static Number convert_dec_to_number(BigDecimal db){
     if( db ==null)
         return null;
      return new Number(db.intValue());
    }
    public static void printArray(Object[] ob){
        for(Object o:ob){
            if(o ==null)
                System.out.println("null");
          System.out.println(o+" :: "+o.getClass());
        }
    }

    public static Number NVL(Number n, Number val) {
        if (n != null)
            return n;
        else
            return val;
    }

    public static Number NVL(Number n) {
        return NVL(n, new Number(0));
    }
    
    public static String StNVL(String s1,String s2)
    {
      if(s1!=null && !"".equalsIgnoreCase(s1))
        return s1;
      return s2;
    }

    public static Number DateToNumber(Date d) {
        String date = FDate.Farsi_from_Georgian(d).replaceAll("/", "");
        Number result = null;
        try {
            result = new Number(date);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public static Number DateToNumber() {
        return DateToNumber(new Date());
    }
    
    public static long daysBetween2Dates(Number d1,Number d2) {
        if(d1==null)
            return 0;
        if(d2==null)
            return 0;
    Date gd1=  FDate.Farsi_to_georgian(d1.intValue()/10000, (d1.intValue()/100)%100, d1.intValue()%100);
      Date gd2=  FDate.Farsi_to_georgian(d2.intValue()/10000, (d2.intValue()/100)%100, d2.intValue()%100);
            
      
      return (gd2.getTime()-gd1.getTime())/(24*60*60*1000);
    }
    

    public static String addDayToPersianDate(Number date, int day) {

        int d = date.intValue();
        Date d1 = FDate.Farsi_to_georgian(d / 10000, (d / 100) % 100, d % 100);
        Calendar c = Calendar.getInstance();
        c.setTime(d1);
        c.add(Calendar.DATE, day);
        Date d2 = null;


        return FDate.Farsi_from_Georgian(c.getTime());
    }


    public static void setAbjad(ArrayList<String> abjad) {
        ParsiUtil.abjad = abjad;
    }

    public static ArrayList<String> getAbjad() {
        if(abjad==null) {
          abjad=new ArrayList<String>();
          abjad.add("الف");
          abjad.add("ب");
          abjad.add("ج");
          abjad.add("د");
          abjad.add("ه");
          abjad.add("و");
          abjad.add("ز");
          abjad.add("ح");
          abjad.add("ط");
          abjad.add("ی");
          abjad.add("ک");
          abjad.add("ل");
          abjad.add("م");
          abjad.add("ن");
          abjad.add("س");
          abjad.add("ع");
          abjad.add("ف");
          abjad.add("ص");
          abjad.add("ق");
          abjad.add("ر");
          abjad.add("ش");
          abjad.add("ت");
          abjad.add("ث");
          abjad.add("خ");
          abjad.add("ذ");
          abjad.add("ض");
          abjad.add("ظ");
          abjad.add("غ");
        }
        return abjad;
    }
    
   

    public static void setEnglishAlphabet(ArrayList<String> englishAlphabet) {
        ParsiUtil.englishAlphabet = englishAlphabet;
    }

    public static ArrayList<String> getEnglishAlphabet() {
      if(englishAlphabet==null)
      {
          englishAlphabet=new ArrayList<String>();
          englishAlphabet.add("a");
        englishAlphabet.add("b");
        englishAlphabet.add("c");
        englishAlphabet.add("d");
        englishAlphabet.add("e");
        englishAlphabet.add("f");
        englishAlphabet.add("g");
        englishAlphabet.add("h");
        englishAlphabet.add("i");
        englishAlphabet.add("j");
        englishAlphabet.add("k");
        englishAlphabet.add("l");
        englishAlphabet.add("m");
        englishAlphabet.add("n");
        englishAlphabet.add("o");
        englishAlphabet.add("p");
        englishAlphabet.add("q");
        englishAlphabet.add("r");
        englishAlphabet.add("s");
        englishAlphabet.add("t");
        englishAlphabet.add("u");
        englishAlphabet.add("v");
        englishAlphabet.add("w");
        englishAlphabet.add("x");
        englishAlphabet.add("y");
        englishAlphabet.add("z");
       
      }
        return englishAlphabet;
    }
}
