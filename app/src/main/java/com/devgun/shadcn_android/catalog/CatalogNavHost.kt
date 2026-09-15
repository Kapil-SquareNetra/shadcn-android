package com.devgun.shadcn_android.catalog

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devgun.shadcn_android.samples.AccordionSamples
import com.devgun.shadcn_android.samples.AlertDialogSamples
import com.devgun.shadcn_android.samples.AlertSamples
import com.devgun.shadcn_android.samples.AspectRatioSamples
import com.devgun.shadcn_android.samples.AttachmentSamples
import com.devgun.shadcn_android.samples.AvatarSamples
import com.devgun.shadcn_android.samples.BadgeSamples
import com.devgun.shadcn_android.samples.BottomNavigationSamples
import com.devgun.shadcn_android.samples.BreadcrumbSamples
import com.devgun.shadcn_android.samples.ButtonGroupSamples
import com.devgun.shadcn_android.samples.ButtonSamples
import com.devgun.shadcn_android.samples.CalendarSamples
import com.devgun.shadcn_android.samples.CardSamples
import com.devgun.shadcn_android.samples.CarouselSamples
import com.devgun.shadcn_android.samples.ChartSamples
import com.devgun.shadcn_android.samples.CheckboxSamples
import com.devgun.shadcn_android.samples.CollapsibleSamples
import com.devgun.shadcn_android.samples.ComboboxSamples
import com.devgun.shadcn_android.samples.ContextMenuSamples
import com.devgun.shadcn_android.samples.DataTableSamples
import com.devgun.shadcn_android.samples.DatePickerSamples
import com.devgun.shadcn_android.samples.DialogSamples
import com.devgun.shadcn_android.samples.DrawerSamples
import com.devgun.shadcn_android.samples.DropdownMenuSamples
import com.devgun.shadcn_android.samples.EmptySamples
import com.devgun.shadcn_android.samples.FieldSamples
import com.devgun.shadcn_android.samples.InputGroupSamples
import com.devgun.shadcn_android.samples.InputOtpSamples
import com.devgun.shadcn_android.samples.InputSamples
import com.devgun.shadcn_android.samples.ItemSamples
import com.devgun.shadcn_android.samples.LabelSamples
import com.devgun.shadcn_android.samples.MessageSamples
import com.devgun.shadcn_android.samples.NavigationRailSamples
import com.devgun.shadcn_android.samples.PaginationSamples
import com.devgun.shadcn_android.samples.ProgressSamples
import com.devgun.shadcn_android.samples.QuestionnaireSamples
import com.devgun.shadcn_android.samples.RadioGroupSamples
import com.devgun.shadcn_android.samples.ScrollAreaSamples
import com.devgun.shadcn_android.samples.SelectSamples
import com.devgun.shadcn_android.samples.SeparatorSamples
import com.devgun.shadcn_android.samples.SheetSamples
import com.devgun.shadcn_android.samples.SidebarSamples
import com.devgun.shadcn_android.samples.SkeletonSamples
import com.devgun.shadcn_android.samples.SliderSamples
import com.devgun.shadcn_android.samples.SnackbarSamples
import com.devgun.shadcn_android.samples.SpinnerSamples
import com.devgun.shadcn_android.samples.SwitchSamples
import com.devgun.shadcn_android.samples.TableSamples
import com.devgun.shadcn_android.samples.TabsSamples
import com.devgun.shadcn_android.samples.TextareaSamples
import com.devgun.shadcn_android.samples.ToggleGroupSamples
import com.devgun.shadcn_android.samples.ToggleSamples
import com.devgun.shadcn_android.samples.TypographySamples

private const val CATALOG_ROUTE = "catalog"

@Composable
fun CatalogNavHost(
    darkTheme: Boolean,
    onToggleTheme: () -> Unit,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = CATALOG_ROUTE,
    ) {
        composable(CATALOG_ROUTE) {
            CatalogScreen(
                darkTheme = darkTheme,
                onToggleTheme = onToggleTheme,
                onNavigateToSample = { destination ->
                    navController.navigate(destination.route)
                },
            )
        }

        composable(CatalogDestination.Button.route) {
            ButtonSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.ButtonGroup.route) {
            ButtonGroupSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Badge.route) {
            BadgeSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Separator.route) {
            SeparatorSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Skeleton.route) {
            SkeletonSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Spinner.route) {
            SpinnerSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Label.route) {
            LabelSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Typography.route) {
            TypographySamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.AspectRatio.route) {
            AspectRatioSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Avatar.route) {
            AvatarSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Input.route) {
            InputSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Textarea.route) {
            TextareaSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.InputGroup.route) {
            InputGroupSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.InputOtp.route) {
            InputOtpSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Checkbox.route) {
            CheckboxSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Switch.route) {
            SwitchSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.RadioGroup.route) {
            RadioGroupSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Slider.route) {
            SliderSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Progress.route) {
            ProgressSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Select.route) {
            SelectSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Field.route) {
            FieldSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Toggle.route) {
            ToggleSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.ToggleGroup.route) {
            ToggleGroupSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Card.route) {
            CardSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Alert.route) {
            AlertSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Empty.route) {
            EmptySamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Item.route) {
            ItemSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Collapsible.route) {
            CollapsibleSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Accordion.route) {
            AccordionSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Dialog.route) {
            DialogSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.AlertDialog.route) {
            AlertDialogSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Sheet.route) {
            SheetSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Drawer.route) {
            DrawerSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.DropdownMenu.route) {
            DropdownMenuSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.ContextMenu.route) {
            ContextMenuSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Snackbar.route) {
            SnackbarSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Tabs.route) {
            TabsSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Breadcrumb.route) {
            BreadcrumbSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Pagination.route) {
            PaginationSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.BottomNavigation.route) {
            BottomNavigationSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.NavigationRail.route) {
            NavigationRailSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Sidebar.route) {
            SidebarSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Calendar.route) {
            CalendarSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.DatePicker.route) {
            DatePickerSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Combobox.route) {
            ComboboxSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Table.route) {
            TableSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.DataTable.route) {
            DataTableSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Carousel.route) {
            CarouselSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.ScrollArea.route) {
            ScrollAreaSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Chart.route) {
            ChartSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Message.route) {
            MessageSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Attachment.route) {
            AttachmentSamples(onBack = { navController.popBackStack() })
        }
        composable(CatalogDestination.Questionnaire.route) {
            QuestionnaireSamples(onBack = { navController.popBackStack() })
        }
    }
}
