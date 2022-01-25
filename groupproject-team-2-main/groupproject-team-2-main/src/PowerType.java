public enum PowerType {
	DOUBLESHOT, TRIPLESHOT, POWERSHOT, NONE;        
	
	public String toString() {
		switch(this) {
			case DOUBLESHOT: return "doubleshot";
			case TRIPLESHOT: return "tripleshot";
			case POWERSHOT: return "powershot";
      		case NONE: return "none";
		}
		return "n/a";
	}
}

