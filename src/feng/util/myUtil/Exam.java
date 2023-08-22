package feng.util.myUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam {
    public static List<String> allWords=new ArrayList<>();
    public static List<String> title=new ArrayList<>();
    public static boolean key=false;
    private static int index;
    private static String number;
    //每道题的分值
    private static String score="0分";
    //根路径
    private static String dir="C:\\Users\\swall\\Downloads\\任务\\考试\\";
    private static String name="试卷.txt";
    //文件名称列表
    private static List<String> files=new ArrayList<>();
    public void getAllWords() throws Exception{
        String paper = dir+name;
        String title = dir+"题目.txt";
        String A = dir+"A.txt";
        String B = dir+"B.txt";
        String C = dir+"C.txt";
        String D = dir+"D.txt";
        String E = dir+"E.txt";
        String F = dir+"F.txt";
        String G = dir+"G.txt";
        String result=dir+"result.txt";   //result一定要放最后
        files= Arrays.asList(title,A, B, C, D, E, F, G,result);
        File file = new File(dir);
        File tmpFile;
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new FileReader(paper));
        String line;
        while ((line=br.readLine())!=null) {
            allWords.add(line);
        }
        br.close();
        //创建文件
        for(String tmp:files){
            if(!(tmpFile=new File(tmp)).exists()){
                tmpFile.createNewFile();
            }
        }
    }
    //执行操作
    public void executeAllWords() throws Exception {
        String start="[1-9][0-9]?\\.";
        String end="本题\\d+分";
        List<BufferedWriter> writers=new ArrayList<>();
        writers = createWriter(files);

        //写出答案
        for(String tmp :allWords){
            //该行为序列号
            if(tmp.matches(start)){
                index=0;
                key=true;
                number=tmp;
                continue;
            }
            //遇到停止符号，停止本轮记录
            if(tmp.matches(end)){
                key=false;
                while(index<8){
                    writers.get(index).write(" \r");
                    writers.get(index).flush();
                    index++;
                }
                continue;
            }
            //该行为可用行
            if(key){
                String value=tmp+"\r";
                if(index==0){
                    value=number+tmp+"\r";
                }
                writers.get(index).write(value);
                writers.get(index).flush();
                index++;
                System.out.println("写入结果为： "+tmp);
                }
            }
        closeWriter(writers);
        }

    public void executeAllWords2() throws Exception {
        String title="[A-Z]、.*";
        String check="[A-Z]、.+";
        String start="[0-9]+.*";
        String end=".*正确答案.*";
        List<BufferedWriter> writers=new ArrayList<>();
        writers = createWriter(files);
        //写出答案
        for(int i=0;i< allWords.size();i++){
            String tmp=allWords.get(i);
            //该行为序列号
            if(index==0 && tmp.matches(start)){
                key=true;
                String tmp2=allWords.get(i+1);
                if(!tmp2.matches(title)){
                    tmp+=tmp2;
                    i++;
                }
                String[] s = tmp.split(score);
                String value=s[0]+"\r";
                writers.get(index).write(value);
                writers.get(index).flush();
                index++;
                continue;
            }
            //遇到停止符号，停止本轮记录
            if(tmp.matches(end)&&key){
                key=false;
                while(index<files.size()-1){
                    writers.get(index).write(" \r");
                    writers.get(index).flush();
                    index++;
                }
                String[] s = tmp.split("正确答案：");
                String value=s[s.length-1]+"\r";
                writers.get(index).write(value);
                writers.get(index).flush();
                index=0;
                continue;
            }
            //该行为可用行
            if(key&& (tmp.matches(title))){
                if(!tmp.matches(check)){
                    tmp+=allWords.get(++i);
                }
                String value=tmp+"\r";
                writers.get(index).write(value);
                writers.get(index).flush();
                index++;
                System.out.println("写入结果为： "+value);
            }
        }
        closeWriter(writers);
    }
    //创建输入流
    public List<BufferedWriter> createWriter(List<String> dirs) throws Exception{
        ArrayList<BufferedWriter> writers = new ArrayList<>();
        for(String dir:dirs){
            writers.add(new BufferedWriter(new FileWriter(dir)));
        }
        return writers;
    }
    public void closeWriter(List<BufferedWriter> writers){
        for(BufferedWriter writer:writers){
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Exam exam = new Exam();
        //获取文件内容
        exam.getAllWords();
//        System.out.println(allWords);
        //写出文件内容
//        exam.executeAllWords();
        exam.executeAllWords2();
    }
}
