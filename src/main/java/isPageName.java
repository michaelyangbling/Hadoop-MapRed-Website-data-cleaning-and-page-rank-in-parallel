import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
//define customized key for data-cleaning MapRed job
public class isPageName implements WritableComparable<isPageName> {//define customized key here
    int isPage;
    String PageName;
    public isPageName() {
    }
    public isPageName(int isPage, String PageName) {
        this.isPage=isPage;
        this.PageName=PageName;
    }

    public void write(DataOutput out) throws IOException {
        out.writeInt(isPage);
        WritableUtils.writeString(out, PageName);
    }

    public void readFields(DataInput in) throws IOException {
        isPage = in.readInt();
        PageName = WritableUtils.readString(in);
    }

    public int compareTo(isPageName ipn) {
        int cmp = Main.compare(isPage, ipn.isPage);
        if (cmp != 0) {
            return cmp;
        }
        return PageName.compareTo(ipn.PageName);//sort2nd.compare(year,sy.year); }


    }
}
