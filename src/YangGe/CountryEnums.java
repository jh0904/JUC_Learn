package YangGe;

import sun.java2d.StateTrackable;

/**
 * YangGe
 *
 * @author jh
 * @date 2018/8/25 19:02
 * description:创建枚举类
 */
public enum CountryEnums {
	ONE(1,"韩"),TWO(2,"魏"),THREE(3,"赵"),FOUR(4,"齐"),FIVE(5,"楚"),SIX(6,"燕");

	private Integer retCode;

	private String retMsg;

	CountryEnums(Integer retCode, String retMsg) {
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public Integer getRetCode() {
		return retCode;
	}

	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public static CountryEnums forEachCountryEnums(Integer index){
		for (CountryEnums enums : values ()) {
			if(enums.getRetCode ()==index){
				return enums;
			}
		}
		return null;
	}
}
