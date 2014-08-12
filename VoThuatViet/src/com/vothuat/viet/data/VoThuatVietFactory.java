package com.vothuat.viet.data;

import android.content.Context;

public class VoThuatVietFactory {
	private static VoThuatVietFactory instance;

	public static VoThuatVietFactory getInstance(Context context) {
		if (instance == null) {
			instance = new VoThuatVietFactory();

		}
		return instance;
	}

	private VoThuatVietFactory() {
	}

	public IItem getCategory(String item) {
		IItem category = null;
		if (item.equalsIgnoreCase("võ thuật việt")) {
			category = new VoThuatViet();
		} else if (item.equalsIgnoreCase("kiến thức võ thuật")) {
			category = new KienThucVoThuat();
		} else if (item.equalsIgnoreCase("võ thuật và sức khỏe")) {
			category = new VoThuatVaSucKhoe();
		} else if (item.equalsIgnoreCase("tài liệu nghiên cứu")) {
			category = new TaiLieuNghienCuu();
		}

		return category;
	}
}
