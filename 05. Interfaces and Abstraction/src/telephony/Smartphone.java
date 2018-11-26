package telephony;

public class Smartphone implements CallPhones,BrowseInWeb{

    @Override
    public void browse(String address) {
        if(address.matches("^.*[0-9]+.*$")) {///^[^0-9]$
            System.out.println("Invalid URL!");
        }
        else {
            System.out.println("Browsing: " + address + "!");
        }
    }

    @Override
    public void callPhone(String phoneNumber) {
       if(phoneNumber.matches("^[0-9]+$")) {
           System.out.println("Calling... " + phoneNumber);
       }
       else {
           System.out.println("Invalid number!");
       }
    }
}
