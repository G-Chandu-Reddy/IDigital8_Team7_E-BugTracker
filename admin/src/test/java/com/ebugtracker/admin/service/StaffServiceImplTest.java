package com.ebugtracker.admin.service;

import com.ebugtracker.admin.entity.Bug;
import com.ebugtracker.admin.constants.BugPriority;
import com.ebugtracker.admin.constants.BugStatus;
import com.ebugtracker.admin.dao.IStaffRepository;
import com.ebugtracker.admin.entity.Staff;
import com.ebugtracker.admin.exceptions.StaffNotFoundException;
import com.ebugtracker.admin.util.AdminUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class StaffServiceImplTest {

    @Mock
    IStaffRepository repository;

    @Mock
    AdminUtility utility;

    @InjectMocks
    @Spy
    StaffServiceImpl service;

    @Test
    public void testAddStaff(){
        Staff staff=mock(Staff.class);
        when (repository.save(staff)).thenReturn(staff);
        Staff result=service.addStaff(staff);
        assertEquals(staff,result);
        assertEquals(staff.getDepartment(),result.getDepartment());
        assertEquals(staff.getStaffId(),result.getStaffId());
        verify(repository).save(staff);
    }

    @Test
    public void testEditStaff(){
        Staff staff=mock(Staff.class);
        doReturn(staff).when(service).findStaffById(staff.getStaffId());
        Staff result=service.editStaff(staff);
        assertEquals(staff,result);
        verify(repository).save(staff);
    }

    @Test
    public void testFindStaffById_1(){
        long id=2;
        Staff staff=mock(Staff.class);
        when(repository.findById(id)).thenReturn(Optional.of(staff));
        Staff result=service.findStaffById(id);
        assertEquals(staff,result);
        assertEquals(staff.getStaffId(),result.getStaffId());
        verify(repository).findById(id);
    }

    @Test
    public void testFindStaffById_2(){
        long id=10;
        Optional<Staff>optional=Optional.empty();
        when(repository.findById(id)).thenReturn(optional);
        Executable executable=()->service.findStaffById(id);
        assertThrows(StaffNotFoundException.class,executable);
    }

    @Test
    public void testFindAll(){
        List<Staff> staffList=new ArrayList<>();
        Staff staff1=new Staff(1,"Chandu","Java",null);
        Staff staff2=new Staff(2,"Rajat","Python",null);
        staffList.add(staff1);
        staffList.add(staff2);
        when(repository.findAll()).thenReturn(staffList);
        List<Staff>result=service.findAll();
        assertEquals(2,result.size());

    }
    @Test
    public void testBugGetBugReport(){
        List<Bug> bugList=new ArrayList<>();

        Bug bug1=new Bug(1L,BugPriority.toEnum("high"), "some code",null,BugStatus.toEnum("open"),"java");
        Bug bug2=new Bug(2L,BugPriority.toEnum("low"),"some code",null,BugStatus.toEnum("open"),"python");
        Bug bug3=new Bug(3L,BugPriority.toEnum("medium"),"some code",null,BugStatus.toEnum("open"),"c#");
        Bug bug4=new Bug(4L,BugPriority.toEnum("low"),"some code",null,BugStatus.toEnum("open"),"c++");
        Bug bug5=new Bug(5L,BugPriority.toEnum("high"),"some code",null,BugStatus.toEnum("open"),"ruby");

        bugList.add(bug1);
        bugList.add(bug2);
        bugList.add(bug3);
        bugList.add(bug4);
        bugList.add(bug5);

        when(utility.getAllBugs()).thenReturn(bugList);
        List<Bug> result=service.getBugReport();
        assertEquals(5,service.getBugReport().size());
        verify(utility).getAllBugs();
    }
    @Test
    public void testGetBugReportByPriority(){
        String level="high";
        List<Bug> bugList=new ArrayList<>();
        Bug bug1=new Bug(1L,BugPriority.toEnum("high"), "some code",null,BugStatus.toEnum("open"),"java");
        Bug bug2=new Bug(2L,BugPriority.toEnum("low"),"some code",null,BugStatus.toEnum("open"),"python");
        Bug bug3=new Bug(3L,BugPriority.toEnum("medium"),"some code",null,BugStatus.toEnum("open"),"c#");
        Bug bug4=new Bug(4L,BugPriority.toEnum("low"),"some code",null,BugStatus.toEnum("open"),"c++");
        Bug bug5=new Bug(5L,BugPriority.toEnum("high"),"some code",null,BugStatus.toEnum("open"),"ruby");

        bugList.add(bug1);
        bugList.add(bug2);
        bugList.add(bug3);
        bugList.add(bug4);
        bugList.add(bug5);
        doReturn(bugList).when(service).getBugReport();
        List<Bug>result=service.getBugReportByPriority(level);
        assertEquals(2,result.size());

    }

    /*@Test
    public void testAssignBugToStaff(){
        long staffId=1;
        String staffName ="Chandu G";
        long ticketId = 1;

        Set<Long>assignedTickets=new HashSet<>();
        assignedTickets.add(ticketId);

        Staff staff=new Staff(staffId,"Chandu G","Java",assignedTickets);
        doReturn(staff).when(service).findStaffById(staffId);

        when(repository.save(staff)).thenReturn(staff);
        Staff resultantStaff=service.assignBugToStaff(staffName,ticketId);
        Boolean result=resultantStaff.getAssignedTicketIds().contains(1L);
        assertEquals(true,result);

    }*/

}
