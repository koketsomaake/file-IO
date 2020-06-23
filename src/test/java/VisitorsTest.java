
import com.sun.tools.javac.util.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class VisitorsTest {


   @Test
    public void load() throws FileNotFoundException {

        Assert.check(true, Visitor.load("koketso"));

    }

    @Test
    public void saves() throws IOException {

        Assert.check (true, Visitor.save("koketso",12,"welcome","tshepo"));

    }
}