package org.gerritcon.mv2016;

import com.google.common.base.Joiner;
public class Printy{
	public static void main(String [] argv){
		new Printy().mainImpl(argv);
	}
	
	void mainImpl(String[] argv)   {

		System.out.println(Joiner.on(' ').join(argv));
	}
}

