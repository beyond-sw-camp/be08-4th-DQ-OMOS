<script setup>
import StudentDetailModal from '@/views/pages/studentDetail/StudentDetailModal.vue';
import { FilterMatchMode, FilterOperator } from '@primevue/core/api';
import axios from 'axios';
import Button from 'primevue/button';
import Column from 'primevue/column';
import DataTable from 'primevue/datatable';
import InputText from 'primevue/inputtext';
import Tag from 'primevue/tag';
import { onBeforeMount, ref } from 'vue';

// Vue Ref 및 Reactive 변수들
const students = ref([]);
const filteredStudents = ref([]); // 필터링된 학생 목록
const filters1 = ref(null);
const loading1 = ref(true);
const selectedStudent = ref(null);
const displayDialog = ref(false);
const classNames = ref([]);
const selectedClass = ref(null);

// API 호출하여 학생 데이터 가져오기
async function fetchStudentList() {
    try {
        const response = await axios.get('http://localhost:8080/api/studentList', {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        students.value = response.data;
        // 선택된 클래스가 있으면 필터링
        filteredStudents.value = selectedClass.value ? students.value.filter((student) => student.className === selectedClass.value) : students.value;
        loading1.value = false;
    } catch (error) {
        console.error('Failed to fetch student list:', error);
        loading1.value = false;
    }
}

async function fetchClassNames() {
    try {
        const response = await axios.get('http://localhost:8080/api/classNames', {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        classNames.value = response.data;
    } catch (error) {
        console.error('Failed to fetch class names:', error);
    }
}

function filterByClass(className) {
    selectedClass.value = className;
    fetchStudentList(); // 선택된 클래스에 따라 학생 데이터를 새로 불러옵니다.
}

function initFilters1() {
    filters1.value = {
        global: { value: null, matchMode: FilterMatchMode.CONTAINS },
        studentName: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] },
        address: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] },
        email: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] },
        phone: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] },
        classNo: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.EQUALS }] },
        className: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.EQUALS }] }, // 정확히 일치하는 값을 필터링
        teacher: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.STARTS_WITH }] },
        openDt: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.DATE_IS }] },
        closeDt: { operator: FilterOperator.AND, constraints: [{ value: null, matchMode: FilterMatchMode.DATE_IS }] }
    };
}

function showStudentDetails(event) {
    console.log('해당 학생 정보 : ', event.data);
    selectedStudent.value = event.data;
    displayDialog.value = true;
}

function formatDate(date) {
    // 예제 포맷, 실제 포맷은 필요에 따라 수정
    return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`;
}

function getSeverity(status) {
    // 예제 구현, 실제 상태에 따라 수정
    return status === 'Active' ? 'success' : 'warning';
}

// 컴포넌트 마운트 전 API 호출
onBeforeMount(() => {
    fetchStudentList();
    fetchClassNames();
    initFilters1();
});
</script>

<template>
    <div class="card">
        <div class="font-semibold text-xl mb-4">전체 학생 목록</div>
        <DataTable
            :value="filteredStudents"
            :paginator="true"
            :rows="10"
            dataKey="studentNo"
            :rowHover="true"
            v-model:filters="filters1"
            filterDisplay="menu"
            :loading="loading1"
            :filters="filters1"
            :globalFilterFields="['studentName', 'className', 'address', 'email']"
            showGridlines
            @row-click="showStudentDetails"
        >
            <template #header>
                <div class="flex justify-between items-center">
                    <div class="flex gap-2">
                        <Button v-for="className in classNames" :key="className" type="button" :label="className" outlined @click="filterByClass(className)" />
                    </div>
                    <div class="relative search-container">
                        <i class="pi pi-search search-icon" />
                        <InputText v-model="filters1['global'].value" placeholder="Keyword Search" class="pl-8" />
                    </div>
                </div>
            </template>
            <template #empty> No students found. </template>
            <template #loading> Loading student data. Please wait. </template>
            <Column field="className" header="기 수" style="min-width: 12rem">
                <template #body="{ data }">
                    {{ data.className }}
                </template>
            </Column>
            <Column field="studentName" header="이 름" style="min-width: 12rem">
                <template #body="{ data }">
                    {{ data.studentName }}
                </template>
            </Column>
            <Column field="address" header="주 소" style="min-width: 12rem">
                <template #body="{ data }">
                    {{ data.address }}
                </template>
            </Column>
            <Column field="openDt" header="개강일" dataType="date" style="min-width: 10rem">
                <template #body="{ data }">
                    {{ formatDate(new Date(data.openDt)) }}
                </template>
            </Column>
            <Column field="closeDt" header="종강일" dataType="date" style="min-width: 10rem">
                <template #body="{ data }">
                    {{ formatDate(new Date(data.closeDt)) }}
                </template>
            </Column>
            <Column field="status" header="상 태" :filterMenuStyle="{ width: '14rem' }" style="min-width: 12rem">
                <template #body="{ data }">
                    <Tag :value="data.status" :severity="getSeverity(data.status)" />
                </template>
            </Column>
        </DataTable>

        <StudentDetailModal :student="selectedStudent" :visible="displayDialog" @update:visible="displayDialog = $event" />
    </div>
</template>

<style scoped lang="scss">
:deep(.p-datatable-frozen-tbody) {
    font-weight: bold;
}

:deep(.p-datatable-scrollable .p-frozen-column) {
    font-weight: bold;
}

.search-container {
    display: flex;
    align-items: center;
    position: relative;
}

.search-icon {
    position: absolute;
    left: 10px; /* Adjust this value to position the icon */
    top: 50%;
    transform: translateY(-50%);
    color: #888; /* Optional: Adjust color */
}

.search-container input {
    padding-left: 2rem; /* Adjust padding to make space for the icon */
}
</style>
