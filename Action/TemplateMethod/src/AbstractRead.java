/**
 *  An abstract class which can get content from a file or a HTTP URL 
 *  or other resource  
 */
public abstract class AbstractRead {
    protected String resource;
    //父类中的模板方法一般为final修饰的，防止具体类重写。
    public void getContent() { // Template Method
        if(open()) {
            readContent();
            close();
        }
    }
    public void setResource(String s) {
        resource = s;
    }
    protected abstract boolean open();
    protected abstract void readContent();
    protected abstract void close();
}
