package cn.ren.util;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendSms {
    /*public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "15835038809");
        request.putQueryParameter("SignName", "���Ƕ��ֳ�");
        request.putQueryParameter("TemplateCode", "SMS_175582625");
        request.putQueryParameter("TemplateParam", "{\"code\":\"1111\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }*/

    //��Ӧ�㰢�����˻��� accessKeyId
    private static final String accessKeyId = "LTAI4FrANJpPurBpRRBQXfty";
    //��Ӧ�㰢�����˻��� accessKeySecret
    private static final String accessKeySecret = "vbVNs3WtbLlbsfjnePyPq5jbNs54bD";
    //��Ӧǩ������
    private static final String signName="���Ƕ��ֳ�";
    //��Ӧģ�����
    private static final String templateCode="SMS_175582625";

    private static int mobile_code = (int)((Math.random()*9+1)*100000);
    /**
     * ���ŷ���
     * @param telphone ���͵��ֻ���
     */
    public static int SendCode(String telphone) {

        DefaultProfile profile = DefaultProfile.getProfile("default",
                accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        //�����ƶ�Ӧ���Ͷ��ŵķ�������ַ
        request.setDomain("dysmsapi.aliyuncs.com");
        //��Ӧ�İ汾��
        request.setVersion("2017-05-25");

        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", telphone);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":"+mobile_code+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return mobile_code;
    }
}
