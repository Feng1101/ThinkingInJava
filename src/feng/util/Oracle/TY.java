package feng.util.Oracle;

import java.io.*;

public class TY {
    public static void main(String[] args) throws IOException{
        for(int i=2023; i<2024; i++){
            //年度
            String setYear= String.valueOf(i);
            String targetYear=String.valueOf(i);
        //配置amt表
//        String a="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\09_GL_VOU_DETAIL.sql";
//        String b="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\amt.sql";
//        amt(a,b);
        String a="C:\\Users\\swall\\Downloads\\任务\\广西\\acco_code.sql";
        String b="C:\\Users\\swall\\Downloads\\任务\\广西\\acco_all.sql";
        amtBal(a,b);


//            gl_head表
//            String gl_head="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\08_GL_VOU_HEAD.sql";
//            String gl_head_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\gl_head_1.sql";
//            String gl_head_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\all_in\\"+setYear+"gl_head.sql";
//            gl_vou_head(gl_head,gl_head_result,"JZ",targetYear);
//        gl_head="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\18_GL_VOU_HEAD.sql";
//        gl_head_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\gl_head_2.sql";
//        gl_vou_head(gl_head,gl_head_result,"QC",targetYear);
//        //gl_detail表
//        String gl_detail="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\09_GL_VOU_DETAIL.sql";
//        String gl_detail_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\gl_detail_1.sql";
//        gl_vou_detail(gl_detail,gl_detail_result,"JZ",targetYear);
//        gl_detail="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\19_GL_VOU_DETAIL.sql";
//        gl_detail_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\gl_detail_2.sql";
//        gl_vou_detail(gl_detail,gl_detail_result,"QC",targetYear);
//        //gl_ass表
//        String gl_ass="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\10_GL_VOU_DETAIL_ASS.sql";
//        String gl_ass_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\gl_ass_1.sql";
//        gl_vou_detail_ass(gl_ass,gl_ass_result,targetYear);
//        gl_ass="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\20_GL_VOU_DETAIL_ASS.sql";
//        gl_ass_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\gl_ass_2.sql";
//        gl_vou_detail_ass(gl_ass,gl_ass_result,targetYear);
//
//
            //pbm_head表
//            String pbm_head="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\14_PBM_VOU_HEAD.sql";
//            String pbm_head_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\pbm_head_1.sql";
//            String pbm_head_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\all_in\\"+setYear+"pbm_head.sql";
//            pbm_vou_head(pbm_head,pbm_head_result,"YS",targetYear);
//
//        pbm_head="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\21_PBM_VOU_HEAD.sql";
//        pbm_head_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\pbm_head_2.sql";
//        pbm_vou_head(pbm_head,pbm_head_result,"QC",targetYear);
//
//        //pbm_detail表
//        String pbm_detail="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\15_PBM_VOU_DETAIL.sql";
//        String pbm_detail_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\pbm_detail_1.sql";
//        pbm_vou_detail(pbm_detail,pbm_detail_result,"YS",targetYear);
//
//        pbm_detail="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\22_PBM_VOU_DETAIL.sql";
//        pbm_detail_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\pbm_detail_2.sql";
//        pbm_vou_detail(pbm_detail,pbm_detail_result,"QC",targetYear);
//
//        //pbm_ass表
//        String pbm_ass="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\16_PBM_VOU_DETAIL_ASS.sql";
//        String pbm_ass_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\pbm_ass_1.sql";
//        pbm_vou_detail_ass(pbm_ass,pbm_ass_result,"YS",targetYear);
//
//        pbm_ass="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\23_PBM_VOU_DETAIL_ASS.sql";
//        pbm_ass_result="C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\pbm_ass_2.sql";
//        pbm_vou_detail_ass(pbm_ass,pbm_ass_result,"QC",targetYear);
//            deleteBySetYear(setYear,targetYear);
        }

    }
    public static void gl_vou_detail(String in,String out,String kind ,String setYear) throws IOException {
        String dir1 =in;
        String dir2 = out;
        File file = new File(dir1);
        File file2=new File(dir2);
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2,true),"GB2312"));
        bw.write("set define off;\n");
        String line;
        int i=0;
        while ((line=br.readLine())!=null && i<1000) {
            i++;
            if(line.startsWith(" insert")){
                StringBuilder sb = new StringBuilder();
                String[] values = line.split("values");
                String[] val = values[1].split(",");
                sb.append(values[0]).append(" values ");
                for(int key =0 ; key<val.length;key++){
                    switch (key){
                        case 0: vou_guid(sb,val,key);break;
                        case 1: detail_guid(sb,val,10,13,14);break;
                        case 3: sb.append("'"+setYear+"',");break;
                        case 8:  sb.append("'"+kind+"',");break;
                        case 10:  acco_code(sb,val,key);break;
                        case 17: vou_date(sb,val,setYear,key); break;
                        default:sb.append(val[key]).append(",");
                    }

                }
                sb.deleteCharAt(sb.length()-1);
                line=sb.toString();
                bw.write(line+"\n");
            }
            if(i==999){
                bw.write("commit;\n");
                bw.flush();
                i=0;
            }
        }
        bw_end(bw);
        br.close();
        bw.close();
    }

    public static void gl_vou_detail_ass(String in,String out ,String setYear) throws IOException {
        String dir1 =in;
        String dir2 = out;

        File file = new File(dir1);
        File file2=new File(dir2);
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2,true),"GB2312"));
        bw.write("set define off;\n");
        String line;
        int i=0;
        while ((line=br.readLine())!=null && i<1000) {
            i++;
            if(line.startsWith(" insert")){
                StringBuilder sb = new StringBuilder();
                String[] values = line.split("values");
                String[] val = values[1].split(",");
                sb.append(values[0]).append(" values ");
                for(int key =0 ; key<val.length;key++){
                    switch (key){
                        case 0: vou_guid(sb,val,key);break;
                        case 1: detail_guid(sb,val,11,13,16);break;
                        case 4:  sb.append("'"+ setYear+ "',"); break;
                        case 11: acco_code(sb,val,key); break;
                        default:  sb.append(val[key]).append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                line=sb.toString();
                bw.write(line+"\n");
            }
            if(i==999){
                bw.write("commit;\n");
                bw.flush();
                i=0;
            }
        }
        bw_end(bw);
        br.close();
        bw.close();
    }

    public static void gl_vou_head(String in,String out,String kind ,String setYear) throws IOException {
        String dir1 =in;
        String dir2 = out;

        File file = new File(dir1);
        File file2=new File(dir2);
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2,true),"GB2312"));
        bw.write("set define off;\n");
        String line;
        int i=0;
        while ((line=br.readLine())!=null && i<1000) {
            i++;
            if(line.startsWith(" insert")){
                StringBuilder sb = new StringBuilder();
                String[] values = line.split("values");
                String[] val = values[1].split(",");
                sb.append(values[0]).append(" values ");
                for(int key =0 ; key<val.length;key++){
                    switch (key){
                        case 0: vou_guid(sb,val,key);break;
                        case 2: sb.append("'"+setYear+"',"); break;
                        case 7: sb.append("'"+kind+"',"); break;
                        case 26: vou_date(sb,val,setYear,key);  break;
                        default: sb.append(val[key]).append(","); break;
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                line=sb.toString();
                bw.write(line+"\n");
            }
            if(i==999){
                bw.write("commit;\n");
                bw.flush();
                i=0;
            }
        }
        bw_end(bw);
        br.close();
        bw.close();
    }

    public static void pbm_vou_detail(String in,String out,String kind ,String setYear) throws IOException {
        String dir1 =in;
        String dir2 = out;
        File file = new File(dir1);
        File file2=new File(dir2);
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2,true),"GB2312"));
        bw.write("set define off;\n");
        String line;
        int i=0;
        while ((line=br.readLine())!=null && i<1000) {
            i++;
            if(line.startsWith(" insert")){
                StringBuilder sb = new StringBuilder();
                String[] values = line.split("values");
                String[] val = values[1].split(",");
                sb.append(values[0]).append(" values ");
                for(int key =0 ; key<val.length;key++){
                    switch (key){
                        case 0: vou_guid(sb,val,key);break;
                        case 1: detail_guid(sb,val,10,13,14);break;
                        case 3: sb.append("'"+setYear+"',");break;
                        case 8:  sb.append("'"+kind+"',");break;
                        case 10:  acco_code(sb,val,key);break;
                        case 17: vou_date(sb,val,setYear,key); break;
                        default:sb.append(val[key]).append(",");
                    }

                }
                sb.deleteCharAt(sb.length()-1);
                line=sb.toString();
                bw.write(line+"\n");
            }
            if(i==999){
                bw.write("commit;\n");
                bw.flush();
                i=0;
            }
        }
        bw_end(bw);
        br.close();
        bw.close();
    }

    public static void pbm_vou_detail_ass(String in,String out ,String kind,String setYear) throws IOException {
        String dir1 =in;
        String dir2 = out;

        File file = new File(dir1);
        File file2=new File(dir2);
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2,true),"GB2312"));
        bw.write("set define off;\n");
        String line;
        int i=0;
        while ((line=br.readLine())!=null && i<1000) {
            i++;
            if(line.startsWith(" insert")){
                StringBuilder sb = new StringBuilder();
                String[] values = line.split("values");
                String[] val = values[1].split(",");
                sb.append(values[0]).append(" values ");
                for(int key =0 ; key<val.length;key++){
                    switch (key){
                        case 0: vou_guid(sb,val,key);break;
                        case 1: detail_guid(sb,val,11,13,16);
                        case 4:  sb.append("'"+ setYear+ "',"); break;
                        case 11: acco_code(sb,val,key); break;
                        case 39: sb.append(("'"+ kind+"',"));break;
                        default:  sb.append(val[key]).append(",");
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                line=sb.toString();
                bw.write(line+"\n");
            }
            if(i==999){
                bw.write("commit;\n");
                bw.flush();
                i=0;
            }
        }
        bw_end(bw);
        br.close();
        bw.close();
    }

    public static void pbm_vou_head(String in,String out,String kind ,String setYear) throws IOException {
        String dir1 =in;
        String dir2 = out;

        File file = new File(dir1);
        File file2=new File(dir2);
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2,true),"GB2312"));
        bw.write("set define off;\n");
        String line;
        int i=0;
        while ((line=br.readLine())!=null && i<1000) {
            i++;
            if(line.startsWith(" insert")){
                StringBuilder sb = new StringBuilder();
                String[] values = line.split("values");
                String[] val = values[1].split(",");
                sb.append(values[0]).append(" values ");
                for(int key =0 ; key<val.length;key++){
                    switch (key){
                        case 0: vou_guid(sb,val,key);break;
                        case 2: sb.append("'"+setYear+"',"); break;
                        case 7: sb.append("'"+kind+"',"); break;
                        case 30: vou_date(sb,val,setYear,key);  break;
                        default: sb.append(val[key]).append(","); break;
                    }
                }
                sb.deleteCharAt(sb.length()-1);
                line=sb.toString();
                bw.write(line+"\n");
            }
            if(i==999){
                bw.write("commit;\n");
                bw.flush();
                i=0;
            }
        }
        bw_end(bw);
        br.close();
        bw.close();
    }

    public static void deleteBySetYear(String setYear,String targetYear) throws IOException {
        File file=new File("C:\\Users\\swall\\Downloads\\任务\\广西\\天翼表\\"+setYear+"\\delete.sql");
        //如果文件不存在，创建文件
        if (!file.exists())
            file.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"GB2312"));
        bw.write("DELETE FROM GL_VOU_HEAD where SET_YEAR= "+ targetYear +"and ACCT_CODE=101001 and AGENCY_CODE='101';\n");
        bw.write("commit;\n");
        bw.write("DELETE FROM GL_VOU_DETAIL where SET_YEAR= "+ targetYear +"and ACCT_CODE=101001 and AGENCY_CODE='101';\n");
        bw.write("commit;\n");
        bw.write("DELETE FROM GL_VOU_DETAIL_ASS where SET_YEAR= "+ targetYear +"and ACCT_CODE=101001 and AGENCY_CODE='101';\n");
        bw.write("commit;\n");
        bw.write("DELETE FROM PBM_VOU_HEAD where SET_YEAR= "+ targetYear +"and ACCT_CODE=101001 and AGENCY_CODE='101';\n");
        bw.write("commit;\n");
        bw.write("DELETE FROM PBM_VOU_DETAIL where SET_YEAR= "+ targetYear +"and ACCT_CODE=101001 and AGENCY_CODE='101';\n");
        bw.write("commit;\n");
        bw.write("DELETE FROM PBM_VOU_DETAIL_ASS where SET_YEAR= "+ targetYear +"and ACCT_CODE=101001 and AGENCY_CODE='101';\n");
        bw.write("commit;\n");
        bw.close();
    }

    private static void vou_date(StringBuilder sb, String [] val,String setYear,int key){
        String[] date = val[key].split("-");
        sb.append("'"+setYear+"-");
        for(int temp=1 ;temp< date.length;temp++){
            sb.append(date[temp]+"-");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(",");
        String s="abcd.";
    }
    private static void acco_code(StringBuilder sb, String[] val, int key){
        String[] acco = val[key].split("\\.");
        for(int n=0; n<acco.length; n++){
            String temp=acco[n];
            int test=temp.length();
            if(temp.startsWith("'")||temp.endsWith("'")){
                test--;
            }
            if(test == 1){
                sb.append("0").append(acco[n]);
            }else {
                sb.append(acco[n]);
            }
        }
        sb.append(",");
    }

    private static String acco_code(String[] val, int key){
        StringBuilder sb = new StringBuilder();
        String[] acco = val[key].split("\\.");
        for(int n=0; n<acco.length; n++){
            String temp=acco[n];
            int test=temp.length();
            if(temp.startsWith("'")||temp.endsWith("'")){
                test--;
            }
            if(test == 1){
                sb.append("0").append(acco[n]);
            }else {
                sb.append(acco[n]);
            }
        }
        return sb.toString();
    }
    private static void vou_guid(StringBuilder sb, String [] val, int key){
        String[] guid = val[key].split(" ");
        for(String s:guid){
            if(!s.equals("")){
                sb.append(s);
            }
        }
//        sb.deleteCharAt(sb.length()-1);
        sb.append(",");
    }
    private static String vou_guid(String [] val, int key){
        StringBuilder sb = new StringBuilder();
        String[] guid = val[key].split(" ");
        for(String s:guid){
            if(!s.equals("")){
                sb.append(s).append("-");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private static void detail_guid(StringBuilder sb,String [] val,int acco_key,int dr_key ,int amt){
        String s = vou_guid(val,0)+acco_code(val, acco_key)+val[dr_key]+val[amt];
        String result = s.replaceAll("'", "");
        StringBuilder temp = new StringBuilder(result);
        temp.deleteCharAt(0);
        sb.append("'"+temp+"',");
    }

    private static void bw_end(BufferedWriter bw) throws IOException{
        bw.write("set define on;\n");
        bw.write("commit;\n");
    }

    private static void amt(String in ,String out)throws  IOException{
        String dir1 =in;
        String dir2 = out;
        File file = new File(dir1);
        File file2=new File(dir2);
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2,true),"GB2312"));
        bw.write("set define off;\n");
        String line;
        int i=0;
        while ((line=br.readLine())!=null && i<1000) {
            i++;
            if(line.startsWith(" insert")){
                StringBuilder sb = new StringBuilder();
                sb.append("insert into akm (OKM,NKM) values (");
                String[] values = line.split("values");
                String[] val = values[1].split(",");
                for(int key =0 ; key<val.length;key++){
                    if(key==10){
                        sb.append(val[10]+", ");
                        String[] acco = val[key].split("\\.");
                        for(int n=0; n<acco.length; n++){
                            String temp=acco[n];
                            int test=temp.length();
                            if(temp.startsWith("'")||temp.endsWith("'")){
                                test--;
                            }
                            if(test == 1){
                                sb.append("0").append(acco[n]);
                            }else {
                                sb.append(acco[n]);
                            }
                        }
                        sb.append(");");
                    }

                }
                line=sb.toString();
                bw.write(line+"\n");
            }
            if(i==999){
                bw.write("commit;\n");
                bw.flush();
                i=0;
            }
        }
        bw_end(bw);
        br.close();
        bw.close();
    }
    private static void amtBal(String in ,String out)throws  IOException{
        String dir1 =in;
        String dir2 = out;
        File file = new File(dir1);
        File file2=new File(dir2);
        //创建BufferedReader读取文件内容
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
        //如果文件不存在，创建文件
        if (!file2.exists())
            file2.createNewFile();
        //创建BufferedWriter对象并向文件写入内容
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2,true),"GB2312"));
        bw.write("set define off;\n");
        String line;
        int i=0;
        while ((line=br.readLine())!=null && i<1000) {
            i++;
            String[] first = line.split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append("insert into akm (OKM,NKM) values ('");
            sb.append(first[0]+"',  '");
            String[] acco = first[0].split("\\.");
            for(int n=0; n<acco.length; n++){
                String temp=acco[n];
                int test=temp.length();
                if(temp.startsWith("'")||temp.endsWith("'")){
                    test--;
                }
                if(test == 1){
                    sb.append("0").append(acco[n]);
                }else {
                    sb.append(acco[n]);
                }
            }
            sb.append("');");

            line=sb.toString();
            bw.write(line+"\n");
            if(i==999){
                bw.write("commit;\n");
                bw.flush();
                i=0;
            }
        }
        bw_end(bw);
        br.close();
        bw.close();
    }
}
