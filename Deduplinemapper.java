
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class Deduplinemapper extends Mapper<LongWritable,Text,TextArrayWritable, NullWritable> {

	Set<String> set=new HashSet<String>();
	
	TextArrayWritable ng=new TextArrayWritable();
	public Text mytxt[];
	
	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException 
	{
		
		set.add(value.toString());
	}
	public void run(Context context) throws IOException, InterruptedException 
	{
		setup(context);
		while(context.nextKeyValue())
		{
			map(context.getCurrentKey(), context.getCurrentValue(), context);
		}
		//String[] newarr=set.toArray(new String[set.size()]);
		 ArrayList<String> list = new ArrayList<String>(set);
		 ArrayList<Text> list1=new ArrayList<Text>();
		 for(String s:list)
		 {
			list1.add(new Text(s));
		 }
		 mytxt=ng.fromArrayList(list1);
		 ng.set(mytxt);
		context.write(ng,NullWritable.get());		
	}
}
