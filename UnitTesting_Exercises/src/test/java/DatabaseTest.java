import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    @Before
    public void initializeTest() throws OperationNotSupportedException {
        database=new Database(1,2);
    }

    @Test
    public void testConstructor()  {
        Assert.assertEquals(2,database.getElements().length);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void expectedExceptionConstructor() throws OperationNotSupportedException {
        Database database1=new Database(1,null);
    }
    @Test
    public void testAdd() {
    }
    @Test
    public void testRemove() {
    }
    @Test
    public void testGetElements() {
    }
}