package org.opensrp.register.mcare.service.scheduling;

import static java.text.MessageFormat.format;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ChildScheduleConstants.SCHEDULE_ENCC;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ChildScheduleConstants.SCHEDULE_ENCC_1;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ChildScheduleConstants.SCHEDULE_ENCC_2;
import static org.opensrp.register.mcare.OpenSRPScheduleConstants.ChildScheduleConstants.SCHEDULE_ENCC_3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.opensrp.common.util.DateUtil;
import org.opensrp.dto.AlertStatus;
import org.opensrp.dto.BeneficiaryType;
import org.opensrp.register.mcare.OpenSRPScheduleConstants.DateTimeDuration;
import org.opensrp.scheduler.HealthSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildSchedulesService {
	
	private static Logger logger = LoggerFactory.getLogger(ChildSchedulesService.class.toString());
	private HealthSchedulerService scheduler;
	private ScheduleLogService scheduleLogService;
	@Autowired
	public ChildSchedulesService(HealthSchedulerService scheduler,ScheduleLogService scheduleLogService){
		this.scheduler = scheduler;
		this.scheduleLogService = scheduleLogService;

	}
	 public void enrollENCCForChild(String caseId, String instanceId, String provider, LocalDate referenceDateForSchedule,String referenceDate) {
	       
		 enrollIntoCorrectMilestoneOfENCCCare(caseId,instanceId,provider, referenceDateForSchedule,referenceDate);
	    }
	    private void enrollIntoCorrectMilestoneOfENCCCare(String entityId, String instanceId, String provider, LocalDate referenceDateForSchedule,String referenceDate) {
	        
	    	String milestone=null;
	        DateTime startDate = null;
	        DateTime expireDate = null;
	        
	        Date date = null;        
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        try {
				date = format.parse(referenceDate);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        DateTime FWBNFDTOO = new DateTime(date);
	        long datediff = ScheduleLogService.getDaysDifference(FWBNFDTOO);
	        System.err.println("datediff:"+datediff);
	        
	        if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Days.ONE.minus(1).toPeriod())) {
	            milestone = SCHEDULE_ENCC_1;
	            startDate = new DateTime(FWBNFDTOO);
	            expireDate = new DateTime(FWBNFDTOO);            
	            scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, milestone, BeneficiaryType.child, AlertStatus.upcoming, FWBNFDTOO, expireDate);

	        } else if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Days.FOUR.toPeriod())) {
	        	
	        	milestone = SCHEDULE_ENCC_2;  
	            startDate = new DateTime(FWBNFDTOO).plusDays(DateTimeDuration.encc1);
	            expireDate = new DateTime(FWBNFDTOO).plusDays(DateTimeDuration.encc2);
	            if(datediff==-1){
	            	scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, SCHEDULE_ENCC_1, BeneficiaryType.child, AlertStatus.urgent, FWBNFDTOO,  new DateTime(FWBNFDTOO).plusDays(DateTimeDuration.encc1));
	            }else if(datediff ==-2){
	            	scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, milestone, BeneficiaryType.child, AlertStatus.upcoming, FWBNFDTOO, new DateTime(FWBNFDTOO).plusDays(3));
	            }else{
	            	scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, milestone, BeneficiaryType.child, AlertStatus.urgent, FWBNFDTOO, expireDate);
	            }

	        } else if (DateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, Days.SEVEN.plus(1).toPeriod())) {
	        	
	        	milestone = SCHEDULE_ENCC_3;
	            startDate = new DateTime(FWBNFDTOO).plusDays(DateTimeDuration.encc2);
	            expireDate = new DateTime(FWBNFDTOO).plusDays(DateTimeDuration.encc3);
	            
	            if(ScheduleLogService.getDaysDifference(FWBNFDTOO)==-5){
	            	scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, SCHEDULE_ENCC_2, BeneficiaryType.child, AlertStatus.urgent, FWBNFDTOO, new DateTime(FWBNFDTOO).plusDays(DateTimeDuration.encc2));
	            }else if(datediff==-6){
	            	 scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, milestone, BeneficiaryType.child, AlertStatus.upcoming, FWBNFDTOO, new DateTime(FWBNFDTOO).plusDays(6));
	            }else if(datediff==-7){
	            	scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, milestone, BeneficiaryType.child, AlertStatus.urgent, FWBNFDTOO, new DateTime(FWBNFDTOO).plusDays(7));
	            }else{
	            	scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, milestone, BeneficiaryType.child, AlertStatus.expired, FWBNFDTOO, new DateTime(FWBNFDTOO).plusDays(8));
	            }
	           

	        } else{
	        	scheduleLogService.scheduleCloseAndSave(entityId, instanceId, provider, SCHEDULE_ENCC, milestone, BeneficiaryType.child, AlertStatus.expired, FWBNFDTOO, new DateTime(FWBNFDTOO).plusDays(8));
	        }

	        logger.info(format("Enrolling ENCC with Entity id:{0} to ENCC schedule, milestone: {1}.", entityId, milestone));
	        scheduler.enrollIntoSchedule(entityId, SCHEDULE_ENCC, milestone, referenceDateForSchedule.toString());
	        
	        
	    	
	    	
	    }
	    
	    public void enrollENCCVisit(String entityId, String sch_name, LocalDate referenceDateForSchedule) {
	        logger.info(format("Enrolling with Entity id:{0} to ENCC schedule, milestone: {1}.", entityId, sch_name));
	        scheduler.enrollIntoSchedule(entityId, SCHEDULE_ENCC, sch_name, referenceDateForSchedule.toString());
	    }
	    
	    public void fullfillMilestone(String entityId, String providerId, String scheduleName,LocalDate completionDate ){
	    	try{
	    		scheduler.fullfillMilestone(entityId, providerId, scheduleName, completionDate);
	    		logger.info("fullfillMilestone with id: :"+entityId);
	    	}catch(Exception e){
	    		logger.info("Does not a fullfillMilestone :"+e.getMessage());
	    	}
	    }
	    
	    public void unEnrollFromSchedule(String entityId, String anmId, String scheduleName) {
	        logger.info(format("Un-enrolling ENCC with Entity id:{0} from schedule: {1}", entityId, scheduleName));
	        scheduler.unEnrollFromSchedule(entityId, anmId, scheduleName);
	    }
}
