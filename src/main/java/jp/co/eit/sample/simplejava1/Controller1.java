package jp.co.eit.sample.simplejava1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Controller1 {
	// DEBUG_MODE
	public static boolean DEBUG_MODE = true;
	public static int CUSTOMER_CODE_INDEX = 0;
	public static int VEHICLE_MGT_NUMBER_INDEX = 1;
	private PreData predata = null;
	public Controller1(){

	}
	public Controller1(PreData predata){
		this.predata = predata;
	}
	// やりかた１
	public void method01(PreData predata){
		System.out.println("bitbucket等にPUSHしなきゃ");
		this.initPreData(predata);
		// step1:
		List<CustVehModel> list01 = this.getListData(DEBUG_MODE,this.predata.getArray01());
		StorageBox box01 = new StorageBox("『g2顧客』",list01,true);
		this.debugOutList(box01);
		// step2:
		List<CustVehModel> list02 = this.getListData(DEBUG_MODE,this.predata.getArray02());
		StorageBox box02 = new StorageBox("『g2車両』",list02,false);
		this.debugOutList(box02);
		// step3
//		List<CustVehModel> list03 = this.calc03(list01,list02);
		List<CustVehModel> list03 = this.calc03(box01,box02);

		StorageBox box03 = new StorageBox("『全対象index』",list03,false);
		this.debugOutList(box03);
		// step4:
		List<CustVehModel> list04 = this.getListData(DEBUG_MODE,this.predata.getArray04());
		StorageBox box04 = new StorageBox("『顧客index』",list04,false);
		this.debugOutList(box04);
		// step5:
		List<CustVehModel> list05 = this.getListData(DEBUG_MODE,this.predata.getArray05());
		StorageBox box05 = new StorageBox("『車両index』",list05,true);
		this.debugOutList(box05);
		// step6
		List<CustVehModel> list06 = this.calc06(list04,list05);
		StorageBox box06 = new StorageBox("『顧客車両index』",list06,true);
		this.debugOutList(box06);
		// step7
		List<CustVehModel> list07 = this.calc07(list03,list06);
		StorageBox box07 = new StorageBox("『検索対象全量index』",list07,true);
		this.debugOutList(box07);
		// step8_1
		List<CustVehModel> list0801 = this.calc0801(list07);
		StorageBox box0801 = new StorageBox("『検索対象全量index』顧客カナ付き",list0801,true);
		this.debugOutList(box0801);
		// step8_2
		List<CustVehModel> list0802 = this.calc0802(list0801);
		StorageBox box0802 = new StorageBox("『検索対象全量index』ソート",list0802,true);
		this.debugOutList(box0802);
		// step9
		List<CustVehModel> list09 = this.calc09(list0802,10);
		StorageBox box09 = new StorageBox("『検索対象index』",list09,true);
		this.debugOutList(box09);
		// step10
		List<?>[] list10Array = this.calc10(list09);
		List<Integer> list10C = (List<Integer>)list10Array[0];
		List<Integer> list10V = (List<Integer>)list10Array[1];

		list10C.forEach(action -> {System.out.println(action);});
		System.out.println();
		list10V.forEach(action -> {System.out.println(action);});
		System.out.println();
	}

	/**
	 * 優先リストを考慮した『全対象index』作成
	 * @param box01
	 * @param box02
	 * @return
	 */
	private List<CustVehModel> calc03(StorageBox box01, StorageBox box02) {
		// TODO 自動生成されたメソッド・スタブ
		List<CustVehModel> list03 = new ArrayList<CustVehModel>();
		List<CustVehModel> list01 = null;
		List<CustVehModel> list02 = null;
		if(box01.isPriority()){
			list01 = box01.getList();
			list02 = box02.getList();
		}else{
			list01 = box02.getList();
			list02 = box01.getList();
		}
		list03.addAll(list01);
		// list03.addAll(list02);
		// 微調整
		for(CustVehModel model02 : list02){
			for(CustVehModel model01 : list01){
				if(model02.getCustomerCode() == model01.getCustomerCode()){
					model02.setExist(true);
				}
			}
		}
		for(CustVehModel model02 : list02){
			if(!model02.isExist()){
				list03.add(model02);
			}
		}
		return list03;
	}
	private void initPreData(PreData predata2) {
		// TODO 自動生成されたメソッド・スタブ
		this.predata = predata2;
	}
	/**
	 *
	 * @param box01
	 */
	private void debugOutList(StorageBox box01) {
		List<CustVehModel> list01 = box01.getList();
		list01.forEach(action -> {
			System.out.println("" + action.getCustomerCode()
			+ "_" + action.getVehicleMgtNumber()
			+ "_" + action.isExist()
			+ ":" + action.getCustomerNameKana1()
					);
		});
		System.out.println("--- debugOutList end --- : " + box01.getName());

	}
	private List<?>[] calc10(List<CustVehModel> list09) {
		// TODO 自動生成されたメソッド・スタブ
		Map<Integer,Integer> mapC = new HashMap<Integer,Integer>();
		Map<Integer,Integer> mapV = new HashMap<Integer,Integer>();
		list09.forEach(action -> {
			mapC.put(action.getCustomerCode(), action.getCustomerCode());
			mapV.put(action.getVehicleMgtNumber(), action.getVehicleMgtNumber());
		});
		List<Integer> listC = new ArrayList<Integer>();
		List<Integer> listV = new ArrayList<Integer>();
		for(Integer c : mapC.keySet()){
			listC.add(c);
		}
		for(Integer v : mapV.keySet()){
			listV.add(v);
		}
		List<?>[] retList = {listC,listV};
		return retList;
	}

	/**
	 * リサイズ
	 * @param list0802
	 * @return
	 */
	private List<CustVehModel> calc09(List<CustVehModel> list0802, int size) {
		// TODO 自動生成されたメソッド・スタブ
		List<CustVehModel> list09 = new ArrayList<CustVehModel>();
		int limit = (size < list0802.size()) ? size : list0802.size();
		System.out.println("[size:list_size:limit] = " + size + ":" + list0802.size() + ":" + limit);
		for(int i = 0 ; i < limit ; i++){
			list09.add(list0802.get(i));
		}
		return list09;
	}

	/**
	 * 顧客名称カナ１で並べ替え：昇順
	 * @param list0801
	 * @return
	 */
	private List<CustVehModel> calc0802(List<CustVehModel> list0801) {
		list0801.sort((a,b)-> a.getCustomerNameKana1().compareTo(b.getCustomerNameKana1()) );
		return list0801;
	}
	/**
	 * 顧客名称カナ１を付与する
	 * @param list07
	 * @return
	 */
	private List<CustVehModel> calc0801(List<CustVehModel> list07) {
		// TODO 自動生成されたメソッド・スタブ
//		List<CustVehModel> list0801 = new ArrayList<CustVehModel>();
		for(CustVehModel model07 : list07){
			model07.setCustomerNameKana1("顧客名称カナ１_" + model07.getCustomerCode());
		}
		return list07;
	}

	/**
	 * 『検索対象全量index』作成
	 * 積集合
	 * @param list03 『全対象index』
	 * @param list06 『顧客車両index』
	 * @return
	 */
	private List<CustVehModel> calc07(List<CustVehModel> list03, List<CustVehModel> list06) {
		// TODO 自動生成されたメソッド・スタブ
		List<CustVehModel> list07 = new ArrayList<CustVehModel>();
		// list07.addAll(list03);
		// list07.addAll(list06);
		// 微調整
		for(CustVehModel model03 : list03){
			for(CustVehModel model06 : list06){
				if(model03.getCustomerCode() == model06.getCustomerCode()){
					model06.setExist(true);
				}
			}
		}
		for(CustVehModel model06 : list06){
			if(model06.isExist()){
				list07.add(model06);
			}
		}
		return list07;
	}

	/**
	 * 『顧客車両index』作成
	 * 積集合
	 * @param list04  『顧客index』
	 * @param list05  『車両index』
	 * @return
	 */
	private List<CustVehModel> calc06(List<CustVehModel> list04, List<CustVehModel> list05) {
		// TODO 自動生成されたメソッド・スタブ
		List<CustVehModel> list06 = new ArrayList<CustVehModel>();
		// list06.addAll(list04);
		// list06.addAll(list05);
		// 微調整
		for(CustVehModel model05 : list05){
			for(CustVehModel model04 : list04){
				if(model05.getCustomerCode() == model04.getCustomerCode()){
					model05.setExist(true);
				}
			}
		}
		for(CustVehModel model05 : list05){
			if(model05.isExist()){
				list06.add(model05);
			}
		}
		return list06;
	}

	/**
	 * 『全対象index』作成
	 * 和集合
	 * @param list01 『g2顧客』
	 * @param list02 『g2車両』
	 * @return
	 */
	private List<CustVehModel> calc03(List<CustVehModel> list01, List<CustVehModel> list02) {
		// TODO 自動生成されたメソッド・スタブ
		List<CustVehModel> list03 = new ArrayList<CustVehModel>();
		list03.addAll(list01);
		// list03.addAll(list02);
		// 微調整
		for(CustVehModel model02 : list02){
			for(CustVehModel model01 : list01){
				if(model02.getCustomerCode() == model01.getCustomerCode()){
					model02.setExist(true);
				}
			}
		}
		for(CustVehModel model02 : list02){
			if(!model02.isExist()){
				list03.add(model02);
			}
		}
		return list03;
	}
	private void debugOutList(List<CustVehModel> list01) {
		// TODO 自動生成されたメソッド・スタブ
		list01.forEach(action -> {
			System.out.println("" + action.getCustomerCode() + "_" + action.getVehicleMgtNumber() + "_" + action.isExist());
		});
		System.out.println("--- debugOutList end ---");
	}
	private void debugOutListMap(List<Map<String, CustVehModel>> list01) {
		// TODO 自動生成されたメソッド・スタブ
		list01.forEach(action -> {
			// ここで key 知らないと取り出せない。
//			System.out.println("" + action.get(key));
		});
		System.out.println("--- debugOutList end ---");
	}

	/**
	 *
	 * @param b
	 * @param inputdata
	 * @return
	 */
	private List<CustVehModel> getListData(boolean b,Integer[][] inputdata) {
		// TODO 自動生成されたメソッド・スタブ
		List<CustVehModel> list01 = new ArrayList<CustVehModel>();
		if(b){
			// 配列からStream
			Stream<Integer[]> stream01 = Arrays.stream(inputdata);
			stream01.forEach(action -> {
				String key = "" + action[CUSTOMER_CODE_INDEX] + "_" + action[VEHICLE_MGT_NUMBER_INDEX];
				CustVehModel val = new CustVehModel();
				val.setCustomerCode(action[CUSTOMER_CODE_INDEX]);
				val.setVehicleMgtNumber(action[VEHICLE_MGT_NUMBER_INDEX]);
				list01.add(val);
			});
		}
		return list01;
	}

	/**
	 * 今のところ使わない：List<Map<String, CustVehModel>>はおおげさかな
	 * @param b
	 * @param inputdata
	 * @return
	 */
	private List<Map<String, CustVehModel>> getListMapData(boolean b,Integer[][] inputdata) {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,CustVehModel>> list01 = new ArrayList<Map<String,CustVehModel>>();
		if(b){
			// 配列からStream
			Stream<Integer[]> stream01 = Arrays.stream(inputdata);
			stream01.forEach(action -> {
				Map<String,CustVehModel> map = new HashMap<String,CustVehModel>();
				String key = "" + action[CUSTOMER_CODE_INDEX] + "_" + action[VEHICLE_MGT_NUMBER_INDEX];
				CustVehModel val = new CustVehModel();
				val.setCustomerCode(action[CUSTOMER_CODE_INDEX]);
				val.setVehicleMgtNumber(action[VEHICLE_MGT_NUMBER_INDEX]);
				map.put(key,val);
				list01.add(map);
			});
		}
		return list01;
	}

}
