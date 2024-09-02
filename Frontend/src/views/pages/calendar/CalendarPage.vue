<template>
    <div class="demo-app">
        <!-- Sidebar -->
        <div class="demo-app-sidebar">
            <p-panel>
                <template #header>
                    사용법
                </template>
                <div>
                    <ul>
                        <li>날짜를 클릭해서 이벤트를 추가할 수 있습니다.</li>
                        <li>생성된 이벤트를 다른 날짜로 옮기거나, 당겨서 날짜를 늘릴 수 있습니다.</li>
                        <li>클릭해서 이벤트를 삭제할 수 있습니다.</li>
                    </ul>
                </div>
            </p-panel>
            <p-panel>
                <template #header>
                    All Events ({{ currentEvents.length }})
                </template>
                <div>
                    <ul>
                        <li v-for="event in currentEvents" :key="event.id">
                            <b>{{ event.startStr }}</b>
                            <i>{{ event.title }}</i> - <span>{{ event.extendedProps.category }}</span>
                        </li>
                    </ul>
                </div>
            </p-panel>
        </div>

        <!-- Main Content -->
        <div class="demo-app-main">
            <FullCalendar class="demo-app-calendar" :options="calendarOptions">
                <template v-slot:eventContent="arg">
                    <b>{{ arg.timeText }}</b>
                    <i>{{ arg.event.title }}</i>
                </template>
            </FullCalendar>
        </div>
    </div>
</template>

<script>
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import timeGridPlugin from '@fullcalendar/timegrid';
import FullCalendar from '@fullcalendar/vue3';
import { defineComponent } from 'vue';
import EventDetailModal from './EventDetailModal.vue';
import EventModal from './EventModal.vue';
import { INITIAL_EVENTS } from '/src/views/pages/calendar/utils/data.js';
import { createEventId } from '/src/views/pages/calendar/utils/event-utils.js';
import Panel from 'primevue/panel';

export default defineComponent({
    components: {
        FullCalendar,
        EventModal,
        EventDetailModal,
        Panel
    },
    data() {
        return {
            calendarOptions: {
                plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay'
                },
                initialView: 'dayGridMonth',
                initialEvents: INITIAL_EVENTS,
                editable: true,
                selectable: true,
                selectMirror: true,
                dayMaxEvents: true,
                weekends: true,
                select: this.handleDateSelect,
                eventClick: this.handleEventClick,
                eventsSet: this.handleEvents
            },
            currentEvents: [],
            isModalOpen: false,
            isDetailModalOpen: false,
            selectedInfo: null,
            selectedEvent: null
        };
    },
    methods: {
        handleDateSelect(selectInfo) {
            this.selectedInfo = selectInfo;
            this.isModalOpen = true;
        },
        handleEventClick(clickInfo) {
            this.selectedEvent = clickInfo.event;
            this.isDetailModalOpen = true;
        },
        handleEvents(events) {
            this.currentEvents = events;
        },
        saveEvent(eventData) {
            let calendarApi = this.selectedInfo.view.calendar;
            calendarApi.unselect();

            const categoryColors = {
                휴가: '#ffcccc',
                출근: '#ccffcc',
                병가: '#ffe6cc',
                조퇴: '#cce6ff',
                회의: '#cce6ff',
                마감: '#ffe6cc',
                리뷰: '#ffe6cc'
            };

            if (eventData.title) {
                calendarApi.addEvent({
                    id: createEventId(),
                    title: eventData.title,
                    start: eventData.start,
                    end: eventData.end,
                    backgroundColor: categoryColors[eventData.category],
                    extendedProps: {
                        category: eventData.category
                    },
                    allDay: this.selectedInfo.allDay
                });
            }
            this.closeModal();
        },
        deleteEvent(event) {
            event.remove();
        },
        closeModal() {
            this.isModalOpen = false;
        },
        closeDetailModal() {
            this.isDetailModalOpen = false;
        }
    }
});
</script>

<style scoped>
.demo-app {
    display: flex;
    min-height: 100%;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
}

.demo-app-sidebar {
    width: 300px;
    line-height: 1.5;
    background: #eaf9ff;
    border-right: 1px solid #d3e2e8;
    padding: 2em;
}

.demo-app-main {
    flex-grow: 1;
    padding: 3em;
}

.fc {
    max-width: 1100px;
    margin: 0 auto;
}
</style>