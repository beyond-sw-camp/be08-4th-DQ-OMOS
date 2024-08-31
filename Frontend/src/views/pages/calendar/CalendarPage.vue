<script>
import dayGridPlugin from '@fullcalendar/daygrid';
import FullCalendar from '@fullcalendar/vue3';

export default {
    components: {
        FullCalendar // make the <FullCalendar> tag available
    },
    data: function () {
        return {
            calendarOptions: {
                plugins: [dayGridPlugin],
                initialView: 'dayGridMonth',
                weekends: false,
                events: [{ title: 'Meeting', start: new Date() }]
            }
        };
    }
};
</script>

<template>
    <FullCalendar class="demo-app-calendar" :options="calendarOptions">
        <template v-slot:eventContent="arg">
            <b>{{ arg.timeText }}</b>
            <i>{{ arg.event.title }}</i>
        </template>
    </FullCalendar>
</template>
