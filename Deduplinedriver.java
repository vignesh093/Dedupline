
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class Deduplinedriver {
	public static void main(String args[]) throws Exception
	{
		if(args.length!=2)
			{
			System.err.println("Usage: Worddrivernewapi <input path> <output path>");
			System.exit(-1);
			}
		Job job=new Job();
		job.setJarByClass(Deduplinedriver.class);
		job.setJobName("Deduplinedriver");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		//job.setInputFormatClass(SequenceFileInputFormat.class);
		//job.setOutputFormatClass(SequenceFileOutputFormat.class);
		job.setMapOutputKeyClass(TextArrayWritable.class);
        job.setMapOutputValueClass(NullWritable.class);
		
		job.setMapperClass(Deduplinemapper.class);
		job.setOutputKeyClass(TextArrayWritable.class);
		job.setOutputValueClass(NullWritable.class);
		
		
		job.setNumReduceTasks(0);
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}

}
