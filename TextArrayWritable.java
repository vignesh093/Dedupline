import java.util.ArrayList;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Text;

public class TextArrayWritable extends ArrayWritable
{
	private Text first[];
    // These two methods are what people say is all you need for
    // creating an ArrayWritable subclass
    public TextArrayWritable() {
        super(Text.class);
    }
   
   public TextArrayWritable(TextArrayWritable[] values) {
       super(Text.class, values);
    }
    public  Text[] fromArrayList(ArrayList<Text> arr)
	{
    //	super(Text.class);
    	//TextArrayWritable writable=new TextArrayWritable();

		/*Text[] values=new Text[strings.length];
		for(int i=0;i<strings.length;i++)
		{
			values[i]=this.get(strings[i]);
		}
		writable.set(values);
		return writable;*/
    	Text[] values=new Text[arr.size()];
    	for(int i=0;i<arr.size();i++)
		{
			values[i]=arr.get(i);
		}
    	// writable.set(values);
    	 return(values);
	}
   /* public String[] returnarray(Text[] mytext)
	{
		//super(Text.class);
		String[] mystr=new String[mytext.length];
		//ArrayList<String> mylist=new ArrayList<String>();
		
		for(int i=0;i<mystr.length;i++)
		{
			mystr[i]=mystr[i].toString();
		}
		return mystr;
	}*/
	
  
	
}
