
package com.ponyinc.minttrack;

import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;

import android.view.View;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.ponyinc.minttrack.R;

public class tipcal extends Activity
{
		EditText bill;
	    EditText tip;
	    EditText split;
	    TextView total;
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.tipcal);
	        
	       
	       // Find the EditTexts
	       bill = (EditText)findViewById(R.id.bill_text);
	       tip = (EditText)findViewById(R.id.tip_text);
	       split = (EditText)findViewById(R.id.split_text);
	       

	       // Bind the action for the save button.
           findViewById(R.id.execute_button).setOnClickListener(mOnClickListener);
           
           
	    }

       

	   View.OnClickListener mOnClickListener = new View.OnClickListener()
	   {
	       public void onClick(View v) 
	       {
	    	   NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	           // When the button is clicked, save the string
	           String s_bill= bill.getText().toString();
	           String s_tip= tip.getText().toString();
	           String s_split= split.getText().toString();
	           
	          
	           float f_bill= new Float(s_bill).floatValue(); 
	           float f_tip= new Float(s_tip).floatValue();
	           float f_split= new Float(s_split).floatValue();
	           double f_total=(f_bill+(f_bill*f_tip/100))/f_split;

	           
	        
	           // show the string in total editText	        
	           String str = n.format(f_total);
	           /**String t_total=total.toString();*/
	           total = (TextView)findViewById(R.id.total_text);
	           total.setText(str);           
	       }
	   };
	   
}