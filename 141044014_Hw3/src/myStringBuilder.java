import java.util.Iterator;

/**
 * Created by Arif on 12.03.2017.
 */
public class myStringBuilder{

    private myLinkedList<Character> strBuilderList = new myLinkedList<>();

    public myStringBuilder(myLinkedList list){
        strBuilderList = list;
    }
    public myStringBuilder(){
    }

    /**
     * This method append anything to SmyStringBuilder
     * @param obj an object
     * @return mystringbuilder
     */
    public myStringBuilder append(Object obj){

       // System.out.println(obj.toString().charAt(1));
        for (int i=0; i< obj.toString().length(); ++i){
            strBuilderList.add(obj.toString().charAt(i));
        }
        return this;
    }

    /**
     * get the object of myStringbuilder
     * @param index integer index
     * @return an object
     */
    public Object get(int index){
        return strBuilderList.get(index);
    }

    /**
     * Override this method for create string by Using index and get
     * @return string
     */
    public String toString(){
        String str = "";
        for (int i=0; i<strBuilderList.getSize(); ++i){
            str +=strBuilderList.get(i).toString()+",";
        }
        return str;
    }

    /**
     * create toSting by using iterator
     * @return String
     */
    public String toStringIterator(){
        String str = "";

        Iterator<Character> it = strBuilderList.Iterator();
        Object temp;
        int i=0;
        while (it.hasNext()){
            temp = it.next();
            if(temp != null){
                str += temp.toString() + ",";
            }
            ++i;
        }
        return str;
    }

    /**
     * Creates to String by Using toString of LinkedList
     * @return String
     */
    public String toStringOfLinkedList(){
        Iterator<Character> it = strBuilderList.Iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            Character e = it.next();
            sb.append(e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    public void  reverseToStringRecursive(){
        //strBuilderList.reverseToString();
        for (int i=strBuilderList.getSize()-1; i>=0; --i){
            System.out.print(strBuilderList.get(i) + ",");
        }
    }


}
