export const AttendanceService = {
    getStudentsData() {
        return [
            {
                id: '2000',
                name: 'John Doe',
                class: 'Grade 10',
                attendanceStatus: '휴가'
            },
            {
                id: '2001',
                name: 'Jane Smith',
                class: 'Grade 10',
                attendanceStatus: '조퇴'
            },
            {
                id: '2002',
                name: 'Michael Johnson',
                class: 'Grade 9',
                attendanceStatus: '병가'
            },
            {
                id: '2003',
                name: 'Emily Davis',
                class: 'Grade 11',
                attendanceStatus: '휴가'
            },
            {
                id: '2004',
                name: 'Daniel Garcia',
                class: 'Grade 10',
                attendanceStatus: '병가'
            },
            {
                id: '2005',
                name: 'Sophia Martinez',
                class: 'Grade 9',
                attendanceStatus: '조퇴'
            },
            {
                id: '2006',
                name: 'Chris Brown',
                class: 'Grade 8',
                attendanceStatus: '휴가'
            },
            {
                id: '2007',
                name: 'Olivia Wilson',
                class: 'Grade 11',
                attendanceStatus: '병가'
            },
        ];
    },

    getStudentsMini() {
        return Promise.resolve(this.getStudentsData().slice(0, 5));
    },

    getStudentsSmall() {
        return Promise.resolve(this.getStudentsData().slice(0, 10));
    },

    getStudents() {
        return Promise.resolve(this.getStudentsData());
    }
};