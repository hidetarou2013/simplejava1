package jp.co.eit.sample.simplejava1;

public class PreData implements PreDataInterface{

	public PreData(){

	}
	public PreData(Integer[][]array01,
			Integer[][]array02,
			Integer[][]array03,
			Integer[][]array04,
			Integer[][]array05,
			Integer[][]array06,
			Integer[][]array07,
			String[][]array0801,
			String[][]array0802,
			String[][]array09,
			Integer[]array10_C,
			Integer[]array10_V){
		this.array01 = array01;
		this.array02 = array02;
		this.array03 = array03;
		this.array04 = array04;
		this.array05 = array05;
		this.array06 = array06;
		this.array07 = array07;
		this.array0801 = array0801;
		this.array0802 = array0802;
		this.array09 = array09;
		this.array10_C = array10_C;
		this.array10_V = array10_V;
	}

	public Integer[][] getArray01() {
		return array01;
	}
	public void setArray01(Integer[][] array01) {
		this.array01 = array01;
	}
	public Integer[][] getArray02() {
		return array02;
	}
	public void setArray02(Integer[][] array02) {
		this.array02 = array02;
	}
	public Integer[][] getArray03() {
		return array03;
	}
	public void setArray03(Integer[][] array03) {
		this.array03 = array03;
	}
	public Integer[][] getArray04() {
		return array04;
	}
	public void setArray04(Integer[][] array04) {
		this.array04 = array04;
	}
	public Integer[][] getArray05() {
		return array05;
	}
	public void setArray05(Integer[][] array05) {
		this.array05 = array05;
	}
	public Integer[][] getArray06() {
		return array06;
	}
	public void setArray06(Integer[][] array06) {
		this.array06 = array06;
	}
	public Integer[][] getArray07() {
		return array07;
	}
	public void setArray07(Integer[][] array07) {
		this.array07 = array07;
	}
	public String[][] getArray0801() {
		return array0801;
	}
	public void setArray0801(String[][] array0801) {
		this.array0801 = array0801;
	}
	public String[][] getArray0802() {
		return array0802;
	}
	public void setArray0802(String[][] array0802) {
		this.array0802 = array0802;
	}
	public String[][] getArray09() {
		return array09;
	}
	public void setArray09(String[][] array09) {
		this.array09 = array09;
	}
	public Integer[] getArray10_C() {
		return array10_C;
	}
	public void setArray10_C(Integer[] array10_C) {
		this.array10_C = array10_C;
	}
	public Integer[] getArray10_V() {
		return array10_V;
	}
	public void setArray10_V(Integer[] array10_V) {
		this.array10_V = array10_V;
	}

	private Integer[][] array01 = {
			{1,0},
			{2,0},
			{3,0},
			{5,0},
	};
	private Integer[][] array02 = {
			{1,1},
			{1,2},
			{4,3},
			{6,4},
	};
	private Integer[][] array03 = {
			{1,0},
			{2,0},
			{3,0},
			{4,3},
			{5,0},
			{6,4},
	};
	private Integer[][] array04 = {
			{1,0},
			{2,0},
			{4,0},
			{13,0},
			{15,0},
	};
	private Integer[][] array05 = {
			{1,1},
			{1,2},
			{1,5},
			{14,14},
			{16,16},
	};
	private Integer[][] array06 = {
			{1,1},
			{1,2},
			{1,5},
	};
	private Integer[][] array07 = {
			{1,1},
			{1,2},
			{1,5},
	};
	private String[][] array0801 = {
			{"1","1","イイイ"},
			{"1","2","イイイ"},
			{"1","5","イイイ"},
	};
	private String[][] array0802 = {
			{"1","1","イイイ"},
			{"1","2","イイイ"},
			{"1","5","イイイ"},
	};
	private String[][] array09 = {
			{"1","1","イイイ"},
			{"1","2","イイイ"},
			{"1","5","イイイ"},
	};
	private Integer[] array10_C = {
			1
	};
	private Integer[] array10_V = {
			1,
			2,
			5,
	};



}
