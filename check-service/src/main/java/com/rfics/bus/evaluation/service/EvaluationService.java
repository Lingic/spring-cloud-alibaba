package com.rfics.bus.evaluation.service;

import com.rfics.unit.ResponseMessage;

public interface EvaluationService {
	
	// 附件1：地方自评报告
	public ResponseMessage readLocalEvaluationReport(int privilege, String zone, int type, String fileName);
	
	// 附件2：专项评估报告
	public ResponseMessage readSpecialEvaluationReport(int privilege, String zone, int type, String fileName);
	
	// 附件3：常规评估报告
	public ResponseMessage readNormalEvaluationReport(int privilege, String zone, int type, String fileName);
	
	// 附件4：整改报告
	public ResponseMessage readReformEvaluationReport(int privilege, String zone, int type, String fileName);
	
	// 附件5：自动评估明细问题
	public ResponseMessage readDetailEvaluationReport(int privilege, String zone, int type, String fileName);
	
	// 附件6：专项&地方合并为同一模板版本类型
	public ResponseMessage readSpecialAndLocalEvaluationReport(int privilege, String zone, int type, String fileName);
}
