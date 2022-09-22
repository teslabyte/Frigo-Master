package mateja.bazamusterija;

import java.util.ArrayList;
import java.util.List;

public class Customers {
    static Musterija m1 = new Musterija("Mateja","1234565","klima ugradnja","Svetosavska 123", 12000);
    static Musterija m2 = new Musterija("Boban","54341234","frizider","Svetosavska 345", 8500);
    static Musterija m3 = new Musterija("John","123123154","zamrzivac","Svetosavska 555", 10000);
    static Musterija m4 = new Musterija("Jack","345345345","rerna","Svetosavska 1", 3500);
    static Musterija m5 = new Musterija("Ted","6786786","masina za ves","Svetosavska 3E", 2850);

    private static  List<MusterijaWrapper> msts = new ArrayList<>();

    public static void LoadCustomerInformation(){
        MusterijaWrapper mwr1 = new MusterijaWrapper(m1, 1, "01.01.2022", MusterijaWrapper.Status.INCOMPLETE);
        MusterijaWrapper mwr2 = new MusterijaWrapper(m2, 2, "02.01.2022", MusterijaWrapper.Status.CANCELED);
        MusterijaWrapper mwr3 = new MusterijaWrapper(m3, 3, "03.01.2022", MusterijaWrapper.Status.COMPLETED);
        MusterijaWrapper mwr4 = new MusterijaWrapper(m4, 4, "04.01.2022", MusterijaWrapper.Status.COMPLETED);
        MusterijaWrapper mwr5 = new MusterijaWrapper(m5, 5, "05.01.2022", MusterijaWrapper.Status.INCOMPLETE);
        msts.add(mwr1);
        msts.add(mwr2);
        msts.add(mwr3);
        msts.add(mwr4);
        msts.add(mwr5);
    }

    public static List<MusterijaWrapper> getMsts(){
        return msts;
    }
}
