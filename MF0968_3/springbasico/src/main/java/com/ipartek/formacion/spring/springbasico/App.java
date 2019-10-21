package com.ipartek.formacion.spring.springbasico;

public class App 
{
    public static void main( String[] args )
    {
    	MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
    	MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
    	
    	mr.setMessageProvider(mp);
    	
    	mr.render();
    }
}
