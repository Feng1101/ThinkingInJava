package feng.util.myUtil;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Info{
    private String pro;
    private String quota;
    private Double money;

    public Info(String pro,String quota,Double money){
        this.pro=pro;
        this.quota=quota;
        this.money=money;
    }
    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
public class XieDao {
    public static void main(String[] args) throws Exception {
        String dir="C:\\Users\\swall\\Downloads\\任务\\广西\\项目期初\\额度0630.txt";
        String outDir="C:\\Users\\swall\\Downloads\\任务\\广西\\项目期初\\余额额度0630.sql";
        File in = new File(dir);
        File out=new File(outDir);
        BufferedReader br = new BufferedReader(new FileReader(in));
        BufferedWriter bw=new BufferedWriter(new FileWriter(out,false));
        String line;
        StringBuilder sb = new StringBuilder();
        DecimalFormat nf = new DecimalFormat("#.00");
        int i=0;
        Queue infos =new LinkedList<Info>();
        while ((line=br.readLine())!=null){
            String[] s = line.split("\t");
//            quotaCode2(sb,nf,s);
            infos.offer(new Info(s[0],s[1],Double.parseDouble(s[2])));
            if(infos.size()==2){
                quotaCodeDiff(sb,nf,infos);
            }
            bw.write(sb.toString());
            sb.delete(0,sb.length());
            i++;
            if(i==5000){
                bw.write("commit;\n");
                i=0;
            }
        }
        bw.close();
        br.close();
    }
    private static void firstStep(StringBuilder sb,DecimalFormat nf,String[] s){
        String pro=s[0];
        double target = Double.parseDouble(s[1]);
        double now=Double.parseDouble(s[s.length-1]);
        target-=now;
        sb.append("update pbm_vou_detail_ass set stad_amt=(stad_amt + "+nf.format(target)+")  where vou_kind='QC' and quota_code like '%99' and project_code = '"+pro+"';\n");
    }

    private static void secondStep(StringBuilder sb,DecimalFormat nf,String[] s){
        String pro=s[0];
        double target = Double.parseDouble(s[1]);
        double now=Double.parseDouble(s[s.length-1]);
        target-=now;
        sb.append("insert into pbm_vou_detail_ass" +
                "  (VOU_GUID," +
                "   DETAIL_GUID," +
                "   DETAIL_ASS_GUID," +
                "   RG_CODE," +
                "   SET_YEAR," +
                "   FIS_PERD," +
                "   AGENCY_CODE," +
                "   VOU_NO," +
                "   VOU_SEQ," +
                "   VOU_DETAIL_SEQ," +
                "   ACCT_CODE," +
                "   ACCO_CODE," +
                "   ACCA_CODE," +
                "   DR_CR," +
                "   STAD_AMT," +
                "   VOU_KIND," +
                "   EXPECO_CODE," +
                "   PROJECT_CODE," +
                "   VOU_TYPE_CODE," +
                "   BILL_DATE," +
                "   QUOTA_CODE)" +
                "   values( '2023-gxdx-qc',SYS_GUID(),SYS_GUID(),'87', 2023,0, '101','0000','1','1', '101001','900302','2','-1',"+
                nf.format(target)+",'QC','*','"+s[0]+"','QC','2023-00-01', 'Z');\n");
    }

    private static void quotaCode(StringBuilder sb,DecimalFormat nf,String[] s){
        String pro=s[0];
        String quotaCode=s[2];
        String key = quotaCode.substring(quotaCode.length() - 2, quotaCode.length());
        if((key.equals("00")||key.equals("01"))&&quotaCode.length()==4)
            return;
        if(key.equals("99"))
            return;
        key = quotaCode.substring(quotaCode.length() - 4, quotaCode.length());
        if(key.equals("0101")||key.equals("0102"))
            return;
        double target = Double.parseDouble(s[3]);
        double now;
        if(s.length<=6)
            now=new Double("0.00");
        else
            now=Double.parseDouble(s[s.length-1]);
        double difference=now-target;
        sb.append("insert into pbm_vou_detail_ass" +
                "  (VOU_GUID," +
                "   DETAIL_GUID," +
                "   DETAIL_ASS_GUID," +
                "   RG_CODE," +
                "   SET_YEAR," +
                "   FIS_PERD," +
                "   AGENCY_CODE," +
                "   VOU_NO," +
                "   VOU_SEQ," +
                "   VOU_DETAIL_SEQ," +
                "   ACCT_CODE," +
                "   ACCO_CODE," +
                "   ACCA_CODE," +
                "   DR_CR," +
                "   STAD_AMT," +
                "   VOU_KIND," +
                "   EXPECO_CODE," +
                "   PROJECT_CODE," +
                "   VOU_TYPE_CODE," +
                "   BILL_DATE," +
                "   QUOTA_CODE)" +
                "   values( '2023-gxdx-qc',SYS_GUID(),SYS_GUID(),'87', 2023,0, '101','0000','1','1', '101001','900302','2','-1',"+
                nf.format(-difference)+",'QC','*','"+pro+"','QC','2023-00-00', '"+quotaCode+"');\n");

        sb.append("insert into pbm_vou_detail_ass" +
                "  (VOU_GUID," +
                "   DETAIL_GUID," +
                "   DETAIL_ASS_GUID," +
                "   RG_CODE," +
                "   SET_YEAR," +
                "   FIS_PERD," +
                "   AGENCY_CODE," +
                "   VOU_NO," +
                "   VOU_SEQ," +
                "   VOU_DETAIL_SEQ," +
                "   ACCT_CODE," +
                "   ACCO_CODE," +
                "   ACCA_CODE," +
                "   DR_CR," +
                "   STAD_AMT," +
                "   VOU_KIND," +
                "   EXPECO_CODE," +
                "   PROJECT_CODE," +
                "   VOU_TYPE_CODE," +
                "   BILL_DATE," +
                "   QUOTA_CODE)" +
                "   values( '2023-gxdx-qc',SYS_GUID(),SYS_GUID(),'87', 2023,0, '101','0000','1','1', '101001','900302','2','-1',"+
                nf.format(difference)+",'QC','*','"+pro+"','QC','2023-00-00', 'Z');\n");
        //sb.append("update pbm_vou_detail_ass set stad_amt=(stad_amt + "+nf.format(difference)+")  where vou_kind='QC' and quota_code like '%99' and project_code = '"+pro+"';\n");
        //sb.append("update pbm_vou_detail_ass set stad_amt=(stad_amt - "+nf.format(difference)+")  where vou_kind='QC' and quota_code='" +quotaCode+ "' and project_code = '"+pro+"';\n");
    }


    private static void quotaCode01(StringBuilder sb,DecimalFormat nf,String[] s){
        String pro=s[0];
        double target = Double.parseDouble(s[2]);
        double difference=target;
        sb.append("insert into pbm_vou_detail_ass" +
                "  (VOU_GUID," +
                "   DETAIL_GUID," +
                "   DETAIL_ASS_GUID," +
                "   RG_CODE," +
                "   SET_YEAR," +
                "   FIS_PERD," +
                "   AGENCY_CODE," +
                "   VOU_NO," +
                "   VOU_SEQ," +
                "   VOU_DETAIL_SEQ," +
                "   ACCT_CODE," +
                "   ACCO_CODE," +
                "   ACCA_CODE," +
                "   DR_CR," +
                "   STAD_AMT," +
                "   VOU_KIND," +
                "   EXPECO_CODE," +
                "   PROJECT_CODE," +
                "   VOU_TYPE_CODE," +
                "   BILL_DATE," +
                "   QUOTA_CODE)" +
                "   values( '2023-gxdx-qc',SYS_GUID(),SYS_GUID(),'87', 2023,0, '101','0000','1','1', '101001','900302','2','-1',"+
                nf.format(difference)+",'QC','*','"+pro+"','QC','2023-06-00', '"+"Z"+"');\n");

    }


    private static void quotaCodeDiff(StringBuilder sb,DecimalFormat nf,Queue<Info> infos){
        Info info1 = infos.remove();
        Info info2 = infos.remove();
        String pro="";
        String quota="";
        double difference=new Double("0.00");
        //对于项目有重复行的，需要进行处理
        //额度长度相同，直接进行保存
        if(info1.getPro().equals(info2.getPro())){
            System.out.println("检测到重复项目，项目编号: "+info1.getPro());
            if(info1.getQuota().length()==info2.getQuota().length()){
                String key1=info1.getQuota().substring(info1.getQuota().length()-2,info1.getQuota().length());
                String key2=info2.getQuota().substring(info2.getQuota().length()-2,info2.getQuota().length());
                if(key1.equals("00")){
                    infos.offer(info2);
                    return;
                }else if(key2.equals("00")){
                    infos.offer(info1);
                    return;
                }
                pro=info1.getPro();
                quota=info1.getQuota();
                difference=info1.getMoney();
                infos.offer(info2);
            }else{//对于不同额度的长度，需要根据情况进行处理，长的必定是02下，根据短的那个后两位决定是否保留
                if(info1.getQuota().length()>info2.getQuota().length()){
                    String key2=info2.getQuota().substring(info2.getQuota().length()-2,info2.getQuota().length());
                    if(key2.equals("00")||key2.equals("02")){
                        infos.offer(info1);
                        return;
                    }
                    infos.offer(info1);
                    pro=info2.getPro();
                    quota=info2.getQuota();
                    difference=info2.getMoney();
                }else {
                    String key1=info1.getQuota().substring(info1.getQuota().length()-2,info1.getQuota().length());
                    if(key1.equals("00")||key1.equals("02")){
                        infos.offer(info2);
                        return;
                    }
                    infos.offer(info2);
                    pro=info1.getPro();
                    quota=info1.getQuota();
                    difference=info1.getMoney();
                }
            }
        }else {
            pro=info1.getPro();
            quota=info1.getQuota();
            difference=info1.getMoney();
            infos.offer(info2);
        }

        sb.append("insert into pbm_vou_detail_ass" +
                "  (VOU_GUID," +
                "   DETAIL_GUID," +
                "   DETAIL_ASS_GUID," +
                "   RG_CODE," +
                "   SET_YEAR," +
                "   FIS_PERD," +
                "   AGENCY_CODE," +
                "   VOU_NO," +
                "   VOU_SEQ," +
                "   VOU_DETAIL_SEQ," +
                "   ACCT_CODE," +
                "   ACCO_CODE," +
                "   ACCA_CODE," +
                "   DR_CR," +
                "   STAD_AMT," +
                "   VOU_KIND," +
                "   EXPECO_CODE," +
                "   PROJECT_CODE," +
                "   VOU_TYPE_CODE," +
                "   BILL_DATE," +
                "   QUOTA_CODE)" +
                "   values( '2023-gxdx-qc',SYS_GUID(),SYS_GUID(),'87', 2023,0, '101','0000','1','1', '101001','900302','2','-1',"+
                nf.format(difference)+",'QC','*','"+pro+"','QC','2023-06-31', '"+quota.substring(0,2)+"99"+"');\n");

    }




}
