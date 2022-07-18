package pages.accounts;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountList {

    List<Account> list = new ArrayList();
    Logger log = Logger.getLogger("APP1");

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    public void printAccountList(){
        Stream<Account> stream = list.stream();
        stream.filter(acc -> acc.getStatus() == AccountStatus.ACTIVE)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
