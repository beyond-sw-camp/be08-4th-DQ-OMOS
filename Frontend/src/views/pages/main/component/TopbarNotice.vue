<script setup>
import { ref } from 'vue';

const showModal = ref(false);

// function toggleModal() {
//     showModal.value = !showModal.value;
// }

function closeModal() {
    showModal.value = false;
}
</script>


<template>
    <div class="layout-topbar-menu hidden lg:block">
        <div class="layout-topbar-actions">

            <!-- 공지사항 버튼 -->
            <button type="button" class="layout-topbar-action" @click="showModal = true">
                <i class="pi pi-inbox" severity="danger"></i>
                <span>Notice</span>
            </button>
            <!-- 모달 창 -->
            <div v-if="showModal" class="NoticeModal" @click="closeModal">
                <div class="NoticeModal-content" @click.stop>
                    <h2>공지사항</h2>
                    <p>공지사항 내용</p>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
/* 모달 오버레이 스타일 */
.NoticeModal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
}

/* 모달 컨텐츠 스타일 */
.NoticeModal-content {
    background: white;
    padding: 20px;
    border-radius: 8px;
    max-width: 500px;
    width: 100%;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}
</style>