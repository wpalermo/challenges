package challenges;

import org.junit.Test;

public class ValidIpAddress {

    @Test
    public void test() {
        this.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        //this.validIPAddress("172.16.254.1");
    }


    public String validIPAddress(String queryIP) {


        if(queryIP.contains(".")) {
            String[] ipV4String = queryIP.split("\\.");

            if (ipV4String.length != 4) {
                return "Neither";
            } else {

                for (String s : ipV4String) {
                    if (s.length() > 1 && s.charAt(0) == '0') {
                        return "Neither";
                    }

                    if (Integer.valueOf(s) > 255) {
                        return "Neither";
                    }
                }

                return "IPv4";

            }
        }

        if(queryIP.contains(":")) {
            String[] ipV6String = queryIP.split(":");
            String hexaDigits = "abcdefABCDEF0123456789";



            if(ipV6String.length != 8) {
                return "Neither";
            } else {

                if(queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() -1) == ':') {
                    return "Neither";
                }

                for(String s : ipV6String) {
                    if(s.length() > 4)
                        return "Neither";

                    if(s.length() == 0)
                        return "Neither";

                    for(Character c : s.toCharArray()) {
                        if(hexaDigits.indexOf(c) == -1) {
                            return "Neither";
                        }
                    }
                }
                return "IPv6";

            }
        }
         return "Neither";
    }
 }
