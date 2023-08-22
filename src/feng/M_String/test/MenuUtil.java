package feng.M_String.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuUtil {
    public static  void main( String args[]) throws IOException {
//        updateMenu();
//        deleteMenu();
//        sqlWrite();
//        insertAccoItem();
        insertAcco();
//        StringBuilder time = new StringBuilder();
//        time.append(System.currentTimeMillis()*3+10086);
//        System.out.println(time.toString());
//        System.out.println(System.currentTimeMillis());
    }

    public static void deleteMenu() throws IOException {
        String dir1 = "C:\\Users\\swall\\Desktop\\临时\\input1.txt";
        String dir2 = "C:\\Users\\swall\\Desktop\\临时\\output.txt";

        File file = new File(dir1);
        File file2=new File(dir2);
        List<String> sqlList = new ArrayList<>();
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line=br.readLine())!=null) {
            sqlList.add(line);
        }
        br.close();
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        //向文件中写入内容cd cw
        int i=1;
        String test=new String();
        for(String key:sqlList){
            test="delete from sys_menu where parent_id='"+key+"';\r";
            System.out.println(test);
            i++;
            bw.write(test);
            bw.flush();
            test="delete from sys_menu where menu_id='"+key+"';\r";
            bw.write(test);
            bw.flush();
        }

        bw.close();
    }
    public static void updateMenu() throws IOException {
        String dir1 = "C:\\Users\\swall\\Desktop\\临时\\input1.txt";
        String dir2 = "C:\\Users\\swall\\Desktop\\临时\\output.txt";

        File file = new File(dir1);
        File file2=new File(dir2);
        List<String> sqlList = new ArrayList<>();
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line=br.readLine())!=null) {
            sqlList.add(line);
        }
        br.close();
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        //向文件中写入内容cd cw
        int i=3;
        String test=new String();
        for(String key:sqlList){
            test="update sys_menu set level_num="+i+" where parent_id='"+key+"' and level_num=2;\r";
            System.out.println(test);
            bw.write(test);
            bw.flush();
        }
        bw.close();
    }
    public static void sqlWrite()throws IOException{
        String dir="C:\\Users\\swall\\Desktop\\临时\\output.txt";
        File file=new File(dir);
        if(!file.exists()){
            file.createNewFile();
        }
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        List<String> list = Arrays.asList("cwy_dlwgy_1017","cwy_fjswdx0707","cwy_gx832_1011","cwy_gxbzk0815","cwy_gxdx0913","cwy_gxmd1013","cwy_jssyp0817","cwy_lzgxy_1014"
        ,"cwy_lztd0920","cwy_lztdxy_0831","cwy_sxnd","cwy_sxykd0817","cwy_sxzyy","cwy_xjxy","cwy_ys0806","cwy_ysk");
        String table1="MA_ELE_ACCO";
        String table2="MA_ELE_ACCO_ACCITEM";
        for(String a:list){
            String key=a.toUpperCase();
            StringBuilder builder1 = new StringBuilder();
            builder1.append("Export Tables=").append(key).append(".").append(table1).append(" User=").append(key).append(" Method=\"SQL Inserts\" Delete DisableTriggers DisableFKs IncludeStorage IncludePrivs Commit=\"100\" Filename=\"C:\\Users\\swall\\Downloads\\Temp\\")
                    .append(key+table1).append(".sql\";\r");
            bw.write(builder1.toString());
            bw.flush();
            StringBuilder builder2 = new StringBuilder();
            builder2.append("Export Tables=").append(key).append(".").append(table2).append(" User=").append(key).append(" Method=\"SQL Inserts\" Delete DisableTriggers DisableFKs IncludeStorage IncludePrivs Commit=\"100\" Filename=\"C:\\Users\\swall\\Downloads\\Temp\\")
                    .append(key+table2).append(".sql\";\r");
            bw.write(builder2.toString());
            bw.flush();
        }

    }


    public static void insertAcco() throws IOException {
        String dir1 = "C:\\Users\\swall\\Desktop\\临时\\input.txt";
        String dir2 = "C:\\Users\\swall\\Desktop\\临时\\output.txt";

        File file = new File(dir1);
        File file2=new File(dir2);
        List<String> sqlList = new ArrayList<>();
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line=br.readLine())!=null) {
            sqlList.add(line);
        }
        br.close();
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        //向文件中写入内容cd cw
        int i=1;
        long l = System.currentTimeMillis();

        for(String string:sqlList){
            StringBuilder test=new StringBuilder();
            String[] s = string.split("\\t");
            System.out.println(s[0]+" "+s[1]+" "+s[2]);
            test.append("insert into MA_ELE_ACCO (CHR_ID, SET_YEAR, RG_CODE, AGENCY_CODE, CHR_CODE, CHR_NAME, CHR_FULLNAME, ACCT_CODE, ACCS_CODE,level_num)\n" +
                    "values (");
            test.append("'87_2022_"+(l+i++)+"', ");
            test.append("2022, ");
            test.append("'87', ");
            test.append("'*',");
            test.append("'"+s[0]+"', ");
            test.append("'"+s[1]+"', ");
            test.append("'"+s[2]+"', ");
            test.append("'*',");
            //accs_code没法整,先随便写一个
            test.append("'0001003',");
            test.append("1);\r");

            System.out.println(test);
            bw.write(test.toString());
            bw.flush();
        }
        bw.close();
    }

    public static void insertAccoItem() throws IOException {
        String dir1 = "C:\\Users\\swall\\Desktop\\临时\\input.txt";
        String dir2 = "C:\\Users\\swall\\Desktop\\临时\\output.txt";

        File file = new File(dir1);
        File file2=new File(dir2);
        List<String> sqlList = new ArrayList<>();
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line=br.readLine())!=null) {
            sqlList.add(line);
        }
        br.close();
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        //向文件中写入内容cd cw
        int i=1;
        long l = System.currentTimeMillis()*2;

        for(String string:sqlList){
            String[] s = string.split("\\t");
            if(s.length>3){
                String tmp = s[3];
                List<String> items = Arrays.asList(tmp.split(","));

                for(String item:items){
                    StringBuilder test=new StringBuilder();
                    test.append("insert into ma_ele_acco_accitem(accitem_id, set_year, agency_code, rg_code, accs_code, acco_code, accitem_code, acct_code, src_agency_code)\n" +
                            "values(");
                    test.append("'87_2022_"+(l+i++)+"', ");
                    test.append("2022, ");
                    test.append("'*', ");
                    test.append("87, ");
                    test.append("'0001003',");
                    test.append("'"+s[0]+"', ");
                    test.append("'"+item+"', ");
                    test.append("'*', ");
                    test.append("'*');\r");
                    System.out.println(test);
                    bw.write(test.toString());
                    bw.flush();
                }
            }
        }
        bw.close();
    }


}
