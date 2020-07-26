package com.rfics.bus.evaluation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfics.bus.evaluation.service.EvaluationService;
import com.rfics.unit.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/evaluation")
public class EvaluationController {
	
	@Autowired
	private EvaluationService evaluationService;
	
	@PostMapping(value="getEvaluationDataBy", produces="application/json;charset=UTF-8")
	public ResponseMessage getEvaluationDataBy(@RequestBody Map<String,Object> map) {
		log.info("getEvaluationDataBy");
		
		ResponseMessage res = new ResponseMessage();
		
		int privilege = (int) map.get("privilege");
		int type = (int) map.get("type");
		String zone = map.get("zone").toString();
		String fileName = map.get("fileName").toString();
		
		switch (type) {
		case 1:
			// 附件1：地方自评报告
			res = evaluationService.readLocalEvaluationReport(privilege, zone, type, fileName);
			break;
		case 2:
			// 附件2：专项评估报告
			res = evaluationService.readSpecialEvaluationReport(privilege, zone, type, fileName);
			break;
		case 3:
			// 附件3：常规评估报告
			res = evaluationService.readNormalEvaluationReport(privilege, zone, type, fileName);
			break;
		case 4:
			// 附件4：整改报告
			res = evaluationService.readReformEvaluationReport(privilege, zone, type, fileName);
			break;
		case 5:
			// 附件5：自动评估明细问题
			res = evaluationService.readDetailEvaluationReport(privilege, zone, type, fileName);
			break;
		case 6:
			// 附件5：自动评估明细问题
			res = evaluationService.readSpecialAndLocalEvaluationReport(privilege, zone, type, fileName);
			break;
			
		default:
			break;
		}
		
		return res;
	}
	
}
