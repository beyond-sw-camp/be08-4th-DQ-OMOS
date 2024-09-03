<script setup>
import { useLayout } from '@/layout/composables/layout';
import { ProductService } from '@/service/ProductService';
import { onMounted, ref, watch, onUnmounted } from 'vue';
import Button from 'primevue/button';
import Dialog from 'primevue/dialog';
import OverlayBadge from 'primevue/overlaybadge';

const alarmDisplayDialog = ref(false);
const selectedNotification = ref(null);
const showMore = ref(false);

// 샘플 알림 데이터
const notifications = [
    { id: 1, iconClass: 'pi pi-map text-green-500', text: '휴가 신청', bgColor: 'bg-green-100 dark:bg-green-400/10' },
    { id: 2, iconClass: 'pi pi-folder-open text-blue-500', text: '조퇴 신청', bgColor: 'bg-blue-100 dark:bg-blue-400/10' },
    { id: 3, iconClass: 'pi pi-envelope text-cyan-500', text: '병가 신청', bgColor: 'bg-cyan-100 dark:bg-cyan-400/10' },
    { id: 4, iconClass: 'pi pi-check-square text-purple-500', text: '지각 신청', bgColor: 'bg-purple-100 dark:bg-purple-400/10' },
    { id: 5, iconClass: 'pi pi-file-edit text-orange-500', text: '출결 신청', bgColor: 'bg-orange-100 dark:bg-orange-400/10' },
  // 추가 알림 항목들...
];

// 모달 열기
function openModal(notification) {
    selectedNotification.value = notification;
    alarmDisplayDialog.value = true;
}

// 모달 닫기
function closeModal() {
    alarmDisplayDialog.value = false;
    selectedNotification.value = null;
}

// 승인 버튼 클릭 처리
function approve() {
    console.log(`승인: ${selectedNotification.value?.text}`);
    closeModal();
}

// 거부 버튼 클릭 처리
function reject() {
    console.log(`거부: ${selectedNotification.value?.text}`);
    closeModal();
}

// 더보기 버튼 클릭 처리
function toggleShowMore() {
    showMore.value = !showMore.value;
}

const { getPrimary, getSurface, isDarkTheme } = useLayout();

// const products = ref(null);
const products = ref([]);
const display = ref(false);
const product = ref({});
const chartData = ref(null);
const chartOptions = ref(null);
const currentDate = ref(new Date().toLocaleString());

function open() {
    display.value = true;
}

function close() {
    display.value = false;
}

const updateDate = () => {
    currentDate.value = new Date().toLocaleString();
};


// 공지사항 데이터 정의
const announcements = ref([
    {
        id: 1,
        type: '일반',
        title: '새로운 강의 안내',
        content: '새로운 Vue.js 강의가 다음 주부터 시작됩니다. 많은 참여 부탁드립니다.',
        date: '2023-09-01'
    },
    {
        id: 2,
        type: '긴급',
        title: '서버 점검 안내',
        content: '내일 오전 2시부터 4시까지 서버 점검이 있을 예정입니다. 서비스 이용에 참고 바랍니다.',
        date: '2023-09-02'
    },
    // 추가 공지사항 항목들...
]);

// Dialog와 선택된 공지사항을 위한 상태 관리
const displayDialog = ref(false);
const selectedAnnouncement = ref(null);

// Dialog 열기 함수
function openDialog(announcement) {
    selectedAnnouncement.value = announcement;
    displayDialog.value = true;
}

// Dialog 닫기 함수
function closeDialog() {
    displayDialog.value = false;
    selectedAnnouncement.value = null;
}

const items = ref([
    { label: 'Add New', icon: 'pi pi-fw pi-plus' },
    { label: 'Remove', icon: 'pi pi-fw pi-trash' }
]);

onMounted(() => {
    ProductService.getProductsSmall().then((data) => (products.value = data));
    chartData.value = setChartData();
    chartOptions.value = setChartOptions();
});

function setChartData() {
    const documentStyle = getComputedStyle(document.documentElement);

    return {
        labels: ['Q1', 'Q2', 'Q3', 'Q4'],
        datasets: [
            {
                type: 'bar',
                label: 'Subscriptions',
                backgroundColor: documentStyle.getPropertyValue('--p-primary-400'),
                data: [4000, 10000, 15000, 4000],
                barThickness: 32
            },
            {
                type: 'bar',
                label: 'Advertising',
                backgroundColor: documentStyle.getPropertyValue('--p-primary-300'),
                data: [2100, 8400, 2400, 7500],
                barThickness: 32
            },
            {
                type: 'bar',
                label: 'Affiliate',
                backgroundColor: documentStyle.getPropertyValue('--p-primary-200'),
                data: [4100, 5200, 3400, 7400],
                borderRadius: {
                    topLeft: 8,
                    topRight: 8
                },
                borderSkipped: true,
                barThickness: 32
            }
        ]
    };
}

function setChartOptions() {
    const documentStyle = getComputedStyle(document.documentElement);
    const borderColor = documentStyle.getPropertyValue('--surface-border');
    const textMutedColor = documentStyle.getPropertyValue('--text-color-secondary');

    return {
        maintainAspectRatio: false,
        aspectRatio: 0.8,
        scales: {
            x: {
                stacked: true,
                ticks: {
                    color: textMutedColor
                },
                grid: {
                    color: 'transparent',
                    borderColor: 'transparent'
                }
            },
            y: {
                stacked: true,
                ticks: {
                    color: textMutedColor
                },
                grid: {
                    color: borderColor,
                    borderColor: 'transparent',
                    drawTicks: false
                }
            }
        }
    };
}

// const formatCurrency = (value) => {
//     return value.toLocaleString('en-US', { style: 'currency', currency: 'USD' });
// };

// Function to format the title (example: make it uppercase)
const formatTitle = (title) => {
    // Example of formatting: convert title to uppercase
    return title ? title.toUpperCase() : '';
};

watch([getPrimary, getSurface, isDarkTheme], () => {
    chartData.value = setChartData();
    chartOptions.value = setChartOptions();
});
</script>

<template>
    <div class="grid grid-cols-12 gap-8">
        <div class="col-span-12 lg:col-span-6 xl:col-span-3">
            <div class="card mb-0">
                <div class="flex justify-between mb-4">
                    <div>
                        <span class="block text-muted-color font-medium mb-4">출결</span>
                        <div class="text-surface-900 dark:text-surface-0 font-medium text-xl">30명</div>
                    </div>
                    <div class="flex items-center justify-center bg-blue-100 dark:bg-blue-400/10 rounded-border" style="width: 2.5rem; height: 2.5rem">
                        <i class="pi pi-check-circle text-blue-500 !text-xl"></i>
                    </div>
                </div>
                <span class="text-muted-color">{{ currentDate }}</span>
            </div>
        </div>
        <div class="col-span-12 lg:col-span-6 xl:col-span-3">
            <div class="card mb-0">
                <div class="flex justify-between mb-4">
                    <div>
                        <span class="block text-muted-color font-medium mb-4">휴가</span>
                        <div class="text-surface-900 dark:text-surface-0 font-medium text-xl">1명</div>
                    </div>
                    <div class="flex items-center justify-center bg-orange-100 dark:bg-orange-400/10 rounded-border" style="width: 2.5rem; height: 2.5rem">
                        <i class="pi pi-map text-orange-500 !text-xl"></i>
                    </div>
                </div>
                <span class="text-muted-color">{{ currentDate }}</span>
            </div>
        </div>
        <div class="col-span-12 lg:col-span-6 xl:col-span-3">
            <div class="card mb-0">
                <div class="flex justify-between mb-4">
                    <div>
                        <span class="block text-muted-color font-medium mb-4">조퇴</span>
                        <div class="text-surface-900 dark:text-surface-0 font-medium text-xl">0명</div>
                    </div>
                    <div class="flex items-center justify-center bg-cyan-100 dark:bg-cyan-400/10 rounded-border" style="width: 2.5rem; height: 2.5rem">
                        <i class="pi pi-folder-open text-cyan-500 !text-xl"></i>
                    </div>
                </div>
                <span class="text-muted-color">{{ currentDate }}</span>
            </div>
        </div>
        <div class="col-span-12 lg:col-span-6 xl:col-span-3">
            <div class="card mb-0">
                <div class="flex justify-between mb-4">
                    <div>
                        <span class="block text-muted-color font-medium mb-4">병가</span>
                        <div class="text-surface-900 dark:text-surface-0 font-medium text-xl">0명</div>
                    </div>
                    <div class="flex items-center justify-center bg-purple-100 dark:bg-purple-400/10 rounded-border" style="width: 2.5rem; height: 2.5rem">
                        <i class="pi pi-envelope text-purple-500 !text-xl"></i>
                    </div>
                </div>
                <span class="text-muted-color">{{ currentDate }}</span>
            </div>
        </div>

        <div class="col-span-12 xl:col-span-6">
            <div class="card">
                <div class="font-semibold text-xl mb-4">공지사항</div>
                <DataTable :value="announcements" :rows="5" :paginator="true" responsiveLayout="scroll">
                    <!-- Type 컬럼 -->
                    <Column field="type" header="Type" style="width: 20%">
                        <template #body="slotProps">
                            <span>{{ slotProps.data.type }}</span>
                        </template>
                    </Column>

                    <!-- Title 컬럼 -->
                    <Column field="title" header="Title" style="width: 50%">
                        <template #body="slotProps">
                            <span>{{ slotProps.data.title }}</span>
                        </template>
                    </Column>

                    <!-- View 버튼 컬럼 -->
                    <Column style="width: 15%" header="View">
                        <template #body="slotProps">
                            <Button 
                                icon="pi pi-search" 
                                type="button" 
                                class="p-button-text" 
                                @click="openDialog(slotProps.data)" 
                            />
                        </template>
                    </Column>
                </DataTable>

                <!-- Dialog -->
                <Dialog header="공지사항 상세" v-model:visible="displayDialog" pt:mask:class="backdrop-blur-md" :breakpoints="{ '960px': '75vw' }" :style="{ width: '30vw' }" :modal="true">
                    <template v-if="selectedAnnouncement">
                        <p class="text-lg font-bold">{{ selectedAnnouncement.title }}</p>
                        <p class="text-sm text-gray-500">{{ selectedAnnouncement.date }}</p>
                        <p class="mt-4 leading-normal">{{ selectedAnnouncement.content }}</p>
                    </template>
                    <template #footer>
                        <Button label="Close" @click="closeDialog" />
                    </template>
                </Dialog>
            </div>
        </div>
        <div class="col-span-12 xl:col-span-6">
            <div class="card">
                <div class="flex items-center justify-between mb-6">
                    <div class="font-semibold text-xl">알림</div>
                    <div>
                        <Button icon="pi pi-ellipsis-v" class="p-button-text p-button-plain p-button-rounded" @click="$refs.menu1.toggle($event)"></Button>
                        <Menu ref="menu1" :popup="true" :model="items" class="!min-w-40"></Menu>
                    </div>
                </div>
                <ul class="p-0 mx-0 mt-0 mb-6 list-none">
                    <li v-for="item in notifications" :key="item.id" class="flex items-center py-2 border-b border-surface cursor-pointer" @click="openModal(item)">
                        <div :class="['w-12 h-12 flex items-center justify-center rounded-full mr-4 shrink-0', item.bgColor]">
                        <OverlayBadge severity="danger">
                            <i :class="item.iconClass" :style="{ fontSize: '1.5rem' }"></i>
                        </OverlayBadge>
                        </div>
                        <span class="text-surface-900 dark:text-surface-0 leading-normal">
                        {{ item.text }}<br>
                        </span>
                    </li>
                    <!-- 더보기 버튼 -->
                    <li v-if="!showMore" class="flex items-center py-2 cursor-pointer" @click="toggleShowMore">
                        <div class="w-full h-12 flex items-center justify-center">
                        <span class="text-blue-500 text-center">
                            더보기
                        </span>
                        </div>
                    </li>
                </ul>

                <!-- 모달 다이얼로그 -->
                <Dialog header="승인/거부" v-model:visible="alarmDisplayDialog" :style="{ width: '30vw' }" modal>
                    <p>선택된 항목: {{ selectedNotification?.text }}</p>
                    <div class="flex justify-end gap-2 mt-4">
                        <Button label="승인" icon="pi pi-check" @click="approve" class="p-button-success" />
                        <Button label="거부" icon="pi pi-times" @click="reject" class="p-button-danger" />
                    </div>
                </Dialog>
            </div>
        </div>
    </div> 
</template>
