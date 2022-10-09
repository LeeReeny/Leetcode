
public class Generic{
    public class generic<T> {
        private T key;

        public generic(T key){
            this.key = key;
        }

        public T getKey(){
            return key;
        }
    };

    generic<Integer> genericInteger = new generic<Integer>(123456);
    generic<String> genericString = new generic<String>("key value");

}

