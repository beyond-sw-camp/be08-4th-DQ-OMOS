<template>
    <div class="modal-overlay" v-if="isOpen">
        <div class="modal-container">
            <h3 class="modal-title">이벤트 상세 정보</h3>
            <div v-if="event">
                <p><strong>이름:</strong> {{ event.title }}</p>
                <p><strong>카테고리:</strong> {{ event.extendedProps.category }}</p>
                <p><strong>시작 날짜 및 시간:</strong> {{ formatDate(event.start) }}</p>
                <p><strong>종료 날짜 및 시간:</strong> {{ formatDate(event.end) }}</p>
            </div>
            <div class="modal-actions">
                <button @click="deleteEvent">삭제</button>
                <button @click="closeModal">닫기</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        isOpen: Boolean,
        event: Object
    },
    methods: {
        formatDate(date) {
            if (!date) return 'N/A';
            return new Date(date).toLocaleString('en-US', {
                day: '2-digit',
                month: '2-digit',
                year: 'numeric',
                hour: '2-digit',
                minute: '2-digit'
            });
        },
        closeModal() {
            this.$emit('close');
        },
        deleteEvent() {
            if (confirm(`이벤트 '${this.event.title}'를 삭제하시겠습니까?`)) {
                this.$emit('delete', this.event);
                this.closeModal();
            }
        }
    }
};
</script>

<style scoped>
.modal-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
}

.modal-container {
    background: white;
    padding: 2em;
    border-radius: 5px;
    width: 300px;
}

.modal-title {
    text-align: center;
    font-size: 1.5em;
    margin-bottom: 1em;
}

.modal-actions {
    display: flex;
    justify-content: space-between;
    margin-top: 1em;
}

button {
    padding: 0.5em 1em;
    border: none;
    background-color: #f44336;
    color: white;
    cursor: pointer;
    border-radius: 4px;
}

button:last-child {
    background-color: #ddd;
    color: black;
}
</style>
