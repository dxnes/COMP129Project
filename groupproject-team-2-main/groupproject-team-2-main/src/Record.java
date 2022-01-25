class Record{
	String name;
	int value;

	public Record(String name, int value){
		this.name = name;
		this.value = value;
	}

	int compareTo(Record record){
		if(name.compareTo(record.name) > 0){
			return 1;
		}
		else if(name.equals(record.name)){
			if(value > record.value){
				return 1;
			}
			else if(value == record.value){
				return 0;
			}
			else{
				return -1;
			}
		}
		else{
			return -1;
		}
	}

	public void print(){
		System.out.println(name + "\t" + value);
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	}
