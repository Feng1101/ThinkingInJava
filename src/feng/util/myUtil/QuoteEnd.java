package feng.util.myUtil;

import java.io.*;
import java.text.DecimalFormat;

public class QuoteEnd {
    public static void main(String[] args) throws Exception {
        String dir="C:\\Users\\swall\\Downloads\\任务\\广西\\项目期初\\额度2.txt";
        String outDir="C:\\Users\\swall\\Downloads\\任务\\广西\\项目期初\\额度2.sql";
        File in = new File(dir);
        File out=new File(outDir);
        BufferedReader br = new BufferedReader(new FileReader(in));
        BufferedWriter bw=new BufferedWriter(new FileWriter(out,false));
        String line;
        StringBuilder sb = new StringBuilder();
        DecimalFormat nf = new DecimalFormat("#.00");
        int i=0;
        String oProject;
        String oQuote;
        line=br.readLine();
        String[] temp = line.split("\t");
        oQuote=temp[2];
        oProject=temp[0];
        quotaCode(sb,nf,temp);
        while ((line=br.readLine())!=null){
            String[] s = line.split("\t");
            if(!oProject.equals(s[0])){
                bw.write(sb.toString());
            }
            sb.delete(0,sb.length());
            oProject=s[0];
            oQuote=s[2];
            quotaCode(sb,nf,s);
            i++;
            if(i==5000){
                bw.write("commit;\n");
                i=0;
            }
        }
        bw.close();
        br.close();
    }

    private static void quotaCode(StringBuilder sb,DecimalFormat nf,String[] s){
        String pro=s[0];
        String quotaCode=s[2];
        String key = quotaCode.substring(quotaCode.length() - 2, quotaCode.length());
        if((key.equals("00")||key.equals("01"))&&quotaCode.length()==4)
            return;
        if(key.equals("99")||key.equals("03"))
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
                nf.format(-difference)+",'QC','*','"+pro+"','QC','2023-00-02', '"+quotaCode+"');\n");

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
                nf.format(difference)+",'QC','*','"+pro+"','QC','2023-00-02', '"+quotaCode.substring(0,2)+"99');\n");
        //sb.append("update pbm_vou_detail_ass set stad_amt=(stad_amt + "+nf.format(difference)+")  where vou_kind='QC' and quota_code like '%99' and project_code = '"+pro+"';\n");
        //sb.append("update pbm_vou_detail_ass set stad_amt=(stad_amt - "+nf.format(difference)+")  where vou_kind='QC' and quota_code='" +quotaCode+ "' and project_code = '"+pro+"';\n");
    }
}
